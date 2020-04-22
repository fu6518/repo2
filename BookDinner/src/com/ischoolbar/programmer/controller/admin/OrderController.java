package com.ischoolbar.programmer.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.Order;
import com.ischoolbar.programmer.page.admin.Page;
import com.ischoolbar.programmer.service.OrderService;

/**
 * ������Ϣ��̨����������
 * @author llq
 *
 */
@RequestMapping("/admin/order")
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * ������Ϣ�б�ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("order/list");
		return model;
	}
	
	/**
	 * ģ����ҳ��ѯ������Ϣ
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(name="name",defaultValue="") String name,
			@RequestParam(name="status",required=false) Integer status,
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("name", name);
		if(status != null && status != -1){
			queryMap.put("status", status);
		}
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", orderService.findList(queryMap));
		ret.put("total", orderService.getTotal(queryMap));
		return ret;
	}
	
	
	
	/**
	 * ������Ϣ�༭
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Order order){
		Map<String, String> ret = new HashMap<String, String>();
		if(order == null){
			ret.put("type", "error");
			ret.put("msg", "����д��ȷ�Ķ�����Ϣ!");
			return ret;
		}
		if(StringUtils.isEmpty(order.getRecieveName())){
			ret.put("type", "error");
			ret.put("msg", "������ϵ�˲���Ϊ��!");
			return ret;
		}
		if(StringUtils.isEmpty(order.getPhone())){
			ret.put("type", "error");
			ret.put("msg", "������ϵ��ʽ����Ϊ��!");
			return ret;
		}
		if(StringUtils.isEmpty(order.getAddress())){
			ret.put("type", "error");
			ret.put("msg", "������ϵ��ַ����Ϊ��!");
			return ret;
		}
		if(orderService.edit(order) <= 0){
			ret.put("type", "error");
			ret.put("msg", "������Ϣ�޸�ʧ�ܣ�����ϵ����Ա!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "�޸ĳɹ���");
		return ret;
	}
	
	/**
	 * ������Ϣɾ��
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(Long id){
		Map<String, String> ret = new HashMap<String, String>();
		if(id == null){
			ret.put("type", "error");
			ret.put("msg", "��ѡ��Ҫɾ���ķ�����Ϣ!");
			return ret;
		}
		try {
			if(orderService.delete(id) <= 0){
				ret.put("type", "error");
				ret.put("msg", "������Ϣɾ��ʧ�ܣ�����ϵ����Ա!");
				return ret;
			}
		} catch (Exception e) {
			
			ret.put("type", "error");
			ret.put("msg", "�ö�����Ϣ�´����Ӷ�����Ϣ������ɾ����ز�Ʒ��Ϣ!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ɾ���ɹ���");
		return ret;
	}
}