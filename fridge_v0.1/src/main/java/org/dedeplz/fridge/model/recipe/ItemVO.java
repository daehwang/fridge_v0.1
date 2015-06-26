package org.dedeplz.fridge.model.recipe;
/**
 * 음식재료 Value Object
 * @author KOSTA
 *
 */
public class ItemVO {
	private int itemNo;
	private String itemName;
	
	public ItemVO(String itemName) {
		super();
		this.itemName = itemName;
	}

	public ItemVO(int itemNo, String itemName) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
	}

	public ItemVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ItemVO [itemNo=" + itemNo + ", itemName=" + itemName + "]";
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
