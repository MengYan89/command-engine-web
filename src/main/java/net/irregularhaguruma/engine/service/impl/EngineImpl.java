package net.irregularhaguruma.engine.service.impl;


import net.irregularhaguruma.engine.config.StConfig;
import net.irregularhaguruma.engine.controller.bean.GroupMessageBean;
import net.irregularhaguruma.engine.controller.bean.MessageBean;
import net.irregularhaguruma.engine.controller.bean.MessageEnum;
import net.irregularhaguruma.engine.http.*;
import net.irregularhaguruma.engine.service.Engine;
import net.irregularhaguruma.engine.service.MessageEngineEnum;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EngineImpl implements Engine {


    @Autowired
    private StApi stApi;

    @Autowired
    private RobotApi robotApi;

    @Override
    public String messageEngine(MessageEngineEnum type, GroupMessageBean messageBean) {
        if (messageBean.getMessage() == null || messageBean.getMessage().isEmpty()) {
            return null;
        }
        if (type == MessageEngineEnum.GROUP_MESSAGE) {
            int index = 0;
            MessageBean top =  messageBean.getMessage().get(index);
            if (MessageEnum.AT.getType().equals(top.getMsgType()) && top.getMsgDate().equals(String.valueOf(messageBean.getBotId()))) {
                // TODO at指令检测
                List<MessageBean> list = messageBean.getMessage();
                list.remove(top);
                for(MessageBean message : messageBean.getMessage()) {
                    if (MessageEnum.PLAIN_TEXT.getType().equals(message.getMsgType())) {
                        if (message.getMsgDate() != null) {
                            if (message.getMsgDate().matches(".*来点涩图.*")) {
                                StApiResponse response = stApi.getSt(1);
                                System.out.println("随机r18涩图请求:" + response);
                                if (response.getCode() == StApiCodeEnum.SUCCESS.getCode()) {
                                    SendMessageBean bean = new SendMessageBean();
                                    bean.setGroupId(messageBean.getGroupId());
                                    bean.setId(messageBean.getId());
                                    bean.setType(MessageTypeEnum.MEMBER_MESSAGE.getType());
                                    List<MessageBean> messageList = new ArrayList<>();
                                    int i = 0;
                                    messageList.add(new MessageBean(i++, MessageEnum.IMAGE.getType(), response.getData().get(0).getUrl()));
                                    bean.setMessage(messageList);
                                    robotApi.sendMessage(bean);
                                    continue;
                                }
                                // API达到额度
                                else if (response.getCode() == StApiCodeEnum.QUOTA_ERROR.getCode()) {

                                } else {
                                    // 其他异常
                                }

                                // System.out.println(stApi.getSt(stConfig.getKey(),stConfig.getSize1200(), stConfig.getR18()));
                            }
                        }
                    }
                }
                return null;
            }
            for(MessageBean message : messageBean.getMessage()) {
                if (MessageEnum.PLAIN_TEXT.getType().equals(message.getMsgType())) {
                    if (message.getMsgDate() != null) {
                        if (message.getMsgDate().matches(".*来点涩图.*")) {
                            SendMessageBean bean = new SendMessageBean();
                            bean.setGroupId(messageBean.getGroupId());
                            bean.setId(messageBean.getId());
                            bean.setType(MessageTypeEnum.GROUP_MESSAGE.getType());
                            List<MessageBean> list = new ArrayList<>();
                            int i = 0;
                            list.add(new MessageBean(i++,MessageEnum.PLAIN_TEXT.getType(),"嗯？"));
                            bean.setMessage(list);
                            robotApi.sendMessage(bean);
                            continue;
                        }
                        if (message.getMsgDate().matches(".*来点二次元.*")) {
                            StApiResponse response = stApi.getSt();
                            System.out.println("随机涩图请求:"+response);
                            if (response.getCode() == StApiCodeEnum.SUCCESS.getCode()) {
                                SendMessageBean bean = new SendMessageBean();
                                bean.setGroupId(messageBean.getGroupId());
                                bean.setId(messageBean.getId());
                                bean.setType(MessageTypeEnum.GROUP_MESSAGE.getType());
                                List<MessageBean> list = new ArrayList<>();
                                int i = 0;
                                list.add(new MessageBean(i++,MessageEnum.AT.getType(),messageBean.getId().toString()));
                                list.add(new MessageBean(i++,MessageEnum.IMAGE.getType(),response.getData().get(0).getUrl()));
                                bean.setMessage(list);
                                robotApi.sendMessage(bean);
                                continue;
                            }
                            // API达到额度
                            else if (response.getCode() == StApiCodeEnum.QUOTA_ERROR.getCode()) {

                            } else {
                                // 其他异常
                            }
                            // System.out.println(stApi.getSt(stConfig.getKey(),stConfig.getSize1200(), stConfig.getR18()));
                        }
                        String rgex = ".*来点(.*)";
                        Pattern pattern = Pattern.compile(rgex);
                        Matcher m = pattern.matcher(message.getMsgDate());
                        if (m.matches()) {
                            String key = m.group(1);
                            StApiResponse response = stApi.getStByKey(key);
                            System.out.println("指定涩图请求:"+response);
                            if (response.getCode() == StApiCodeEnum.SUCCESS.getCode()) {
                                SendMessageBean bean = new SendMessageBean();
                                bean.setGroupId(messageBean.getGroupId());
                                bean.setId(messageBean.getId());
                                bean.setType(MessageTypeEnum.GROUP_MESSAGE.getType());
                                List<MessageBean> list = new ArrayList<>();
                                int i = 0;
                                list.add(new MessageBean(i++,MessageEnum.AT.getType(),messageBean.getId().toString()));
                                list.add(new MessageBean(i++,MessageEnum.IMAGE.getType(),response.getData().get(0).getUrl()));
                                bean.setMessage(list);
                                robotApi.sendMessage(bean);
                                continue;
                            }
                            // API达到额度
                            else if (response.getCode() == StApiCodeEnum.QUOTA_ERROR.getCode()) {

                            }
                            // 没有找到指定关键字
                            else if (response.getCode() == StApiCodeEnum.KEYWORD_ISNULL.getCode()) {
                                SendMessageBean bean = new SendMessageBean();
                                bean.setGroupId(messageBean.getGroupId());
                                bean.setId(messageBean.getId());
                                bean.setType(MessageTypeEnum.GROUP_MESSAGE.getType());
                                List<MessageBean> list = new ArrayList<>();
                                int i = 0;
                                list.add(new MessageBean(i++,MessageEnum.AT.getType(),messageBean.getId().toString()));
                                list.add(new MessageBean(i++,MessageEnum.PLAIN_TEXT.getType(), "你的xp太怪了"));
                                bean.setMessage(list);
                                robotApi.sendMessage(bean);
                                continue;
                            } else{
                                // 其他异常
                            }
                        }


                    }

                }
            }
        }
        return null;
    }

}
