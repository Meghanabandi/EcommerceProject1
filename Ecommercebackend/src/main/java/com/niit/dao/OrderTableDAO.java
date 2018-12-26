package com.niit.dao;


	import java.util.List;

import com.niit.model.OrderTable;

	public interface OrderTableDAO {
		
		public boolean save(OrderTable orderTable);
		public List<OrderTable> list(String userId);

	}


