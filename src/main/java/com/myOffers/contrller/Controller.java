package com.myOffers.contrller;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myOffers.util.ApplicationDao;
import com.myOffers.util.SpringContextInit;

@RestController
public class Controller {

	@RequestMapping(value = "/empLogin", method = RequestMethod.POST, headers = "Accept=text/json")
	public ResponseEntity<String> getLogin(@RequestBody LoginStatusBean objLoginStatusBean) {
		try {

			ApplicationContext context = SpringContextInit.getContext();
			ApplicationDao objApplicationDao = (ApplicationDao) context.getBean("applicationDao");

			objLoginStatusBean = objApplicationDao.getLoginBean(objLoginStatusBean.getUserName(),
					objLoginStatusBean.getPassWord());

			if (objLoginStatusBean == null) {
				return new ResponseEntity<String>(toJSON(objLoginStatusBean), HttpStatus.OK);
			}

		} catch (Exception e) {

		}

		return new ResponseEntity<String>(toJSON(objLoginStatusBean), HttpStatus.OK);
	}
}
