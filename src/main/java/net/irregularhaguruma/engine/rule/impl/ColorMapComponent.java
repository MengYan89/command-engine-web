package net.irregularhaguruma.engine.rule.impl;

import net.irregularhaguruma.engine.controller.bean.MessageBean;
import net.irregularhaguruma.engine.controller.bean.MessageEnum;
import net.irregularhaguruma.engine.http.*;
import net.irregularhaguruma.engine.rule.GroupRuleComponent;
import net.irregularhaguruma.engine.util.SpringContextUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ColorMapComponent implements GroupRuleComponent {
    private Pattern pattern =  Pattern.compile(".*来点二次元.*");

    @Override
    public void execution(List<MessageBean> messageList, long groupId, long id) {
        for(MessageBean message : messageList) {
            if (MessageEnum.PLAIN_TEXT.getType().equals(message.getMsgType())) {
                if (pattern.matcher(message.getMsgDate()).matches()) {
                    StApi stApi = (StApi) SpringContextUtil.getBean(StApi.class);
                    RobotApi robotApi = (RobotApi) SpringContextUtil.getBean(RobotApi.class);
                    StApiResponse response = stApi.getSt();
                    System.out.println("随机涩图请求:"+response);
                    if (response.getCode() == StApiCodeEnum.SUCCESS.getCode()) {
                        SendMessageBean bean = new SendMessageBean();
                        bean.setGroupId(groupId);
                        bean.setId(id);
                        bean.setType(MessageTypeEnum.GROUP_MESSAGE.getType());
                        List<MessageBean> list = new ArrayList<>();
                        int i = 0;
                        list.add(new MessageBean(i++,MessageEnum.AT.getType(),String.valueOf(id)));
                        list.add(new MessageBean(i++,MessageEnum.IMAGE.getType(),response.getData().get(0).getUrl()));
                        bean.setMessage(list);
                        robotApi.sendMessage(bean);
                        continue;
                    }
                    // API达到额度
                    else if (response.getCode() == StApiCodeEnum.QUOTA_ERROR.getCode()) {
                        SendMessageBean bean = new SendMessageBean();
                        bean.setGroupId(groupId);
                        bean.setId(id);
                        bean.setType(MessageTypeEnum.GROUP_MESSAGE.getType());
                        List<MessageBean> list = new ArrayList<>();
                        int i = 0;
                        list.add(new MessageBean(i++,MessageEnum.PLAIN_TEXT.getType(),"你们太涩了,今天已经没有了"));
                        bean.setMessage(list);
                        robotApi.sendMessage(bean);
                        continue;
                    } else {
                        // 其他异常
                    }
                    // System.out.println(stApi.getSt(stConfig.getKey(),stConfig.getSize1200(), stConfig.getR18()));
                }
            }
        }

    }
}
