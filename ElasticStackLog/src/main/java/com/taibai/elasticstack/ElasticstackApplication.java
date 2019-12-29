package com.taibai.elasticstack;

import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class ElasticstackApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticstackApplication.class);

	public static final String[] VISIT = new String[]{"浏览页面", "评论商品", "加入收藏", "加入购物车", "提交订单", "使用优惠券", "领取优惠券", "搜索", "查看订单"};

	public static void main(String[] args) {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String userId = UUID.randomUUID().toString().substring(0,10);
			String visit = VISIT[new Random().nextInt(VISIT.length)];
			DateTime now = new DateTime();
			int maxHour = now.getHourOfDay();
			int maxMillis = now.getMinuteOfHour();
			int maxSeconds = now.getSecondOfMinute();
			String date = now.plusHours(-(RandomUtils.nextInt(0, maxHour)))
					.plusMinutes(-(RandomUtils.nextInt(0, maxMillis)))
					.plusSeconds(-(RandomUtils.nextInt(0, maxSeconds)))
					.toString("yyyy-MM-dd HH:mm:ss");
			String result = "taibai," + userId + "," + visit + "," + date;
			LOGGER.info(result);
		}
	}

}
