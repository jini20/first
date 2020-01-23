package first.web.vo;

public class StringDividerVO {

	String targetUrl;
	String removeTags;
	int quantity;
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	public String getRemoveTags() {
		return removeTags;
	}
	public void setRemoveTags(String removeTags) {
		this.removeTags = removeTags;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "StringDividerVO [targetUrl=" + targetUrl + ", removeTags=" + removeTags + ", quantity=" + quantity
				+ "]";
	}	
}
