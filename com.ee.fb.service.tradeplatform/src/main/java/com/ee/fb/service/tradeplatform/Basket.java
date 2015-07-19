package com.ee.fb.service.tradeplatform;

import java.util.List;

import com.ee.domain.product.Product;

public interface Basket {
	public void addOneProduct(Product product);

	public void addOneProduct(String productId);

	public void addProduct(Product product, int count);

	public void addProduct(String productId, int count);

	public void addItem(BasketItem item);

	public void addItem(List<BasketItem> items);

	public List<BasketItem> getItems();

	public int getCountForProduct(Product product);

	public int getCountForProduct(String productId);

	public void removeOneProduct(Product product);

	public void removeOneProduct(String productId);

	public void removeAllProduct(Product product);

	public void removeAllProduct(String productId);

	public void removeItem(BasketItem item);

	public void clear();
}
