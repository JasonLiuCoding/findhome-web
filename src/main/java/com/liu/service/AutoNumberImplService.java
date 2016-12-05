package com.liu.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liu.dao.AutoNumberDao;
import com.liu.model.AutoNumberItem;
import com.liu.model.AutoNumberType;

@Service
public class AutoNumberImplService implements AutoNumberService {
	private ConcurrentHashMap<String, AutoNumberItem> type2AutoNumberMap = new ConcurrentHashMap<String, AutoNumberItem>();

	@Resource
	private AutoNumberDao dao;

	@Override
	public int getNextNumber(AutoNumberType type) {
		return getNextNumber(type, false);
	}

	public int getNextNumber(AutoNumberType type, boolean needFromDB) {
		AutoNumberItem item = type2AutoNumberMap.get(type.name);
		if (needFromDB || item == null) {
			AutoNumberItem newStep = getNewStep(type);
			type2AutoNumberMap.putIfAbsent(type.name, newStep);
			item = newStep;
		}

		int next = item.getNext();
		int maxNumber = item.getMax();
		if (next > maxNumber) {
			return getNextNumber(type, true);
		}
		return next;
	}

	@Transactional
	private AutoNumberItem getNewStep(AutoNumberType type) {
		AutoNumberItem item = dao.select(type.name);
		item = new AutoNumberItem(item.getStart(), item.getStep());// �������ѯ�����Ľ�����ÿչ��캯�����Զ��������ֵΪĬ��ֵ
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", type.name);
		params.put("inc", item.getStep());
		dao.update(params);
		return item;
	}

}
