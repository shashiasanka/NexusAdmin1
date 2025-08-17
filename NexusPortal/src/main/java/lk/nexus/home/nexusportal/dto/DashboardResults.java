package lk.nexus.home.nexusportal.dto;

public class DashboardResults {


	public String newOrderval;	
	public String receiveToWearhouseval;
	public String dispatchFromWearhouseval;
	public String receiveToBranchval;	
	public String dispatchFromBranchval;	
	public String orderCompletedval;
	public String orderFailedval;
	public String returnToBranchval;	
	public String returnToWearhouseval;
	
	public String getNewOrderval() {
		return newOrderval;
	}
	public void setNewOrderval(String newOrderval) {
		this.newOrderval = newOrderval;
	}
	public String getReceiveToWearhouseval() {
		return receiveToWearhouseval;
	}
	public void setReceiveToWearhouseval(String receiveToWearhouseval) {
		this.receiveToWearhouseval = receiveToWearhouseval;
	}
	public String getDispatchFromWearhouseval() {
		return dispatchFromWearhouseval;
	}
	public void setDispatchFromWearhouseval(String dispatchFromWearhouseval) {
		this.dispatchFromWearhouseval = dispatchFromWearhouseval;
	}
	public String getReceiveToBranchval() {
		return receiveToBranchval;
	}
	public void setReceiveToBranchval(String receiveToBranchval) {
		this.receiveToBranchval = receiveToBranchval;
	}
	public String getDispatchFromBranchval() {
		return dispatchFromBranchval;
	}
	public void setDispatchFromBranchval(String dispatchFromBranchval) {
		this.dispatchFromBranchval = dispatchFromBranchval;
	}
	public String getOrderCompletedval() {
		return orderCompletedval;
	}
	public void setOrderCompletedval(String orderCompletedval) {
		this.orderCompletedval = orderCompletedval;
	}
	public String getOrderFailedval() {
		return orderFailedval;
	}
	public void setOrderFailedval(String orderFailedval) {
		this.orderFailedval = orderFailedval;
	}
	public String getReturnToBranchval() {
		return returnToBranchval;
	}
	public void setReturnToBranchval(String returnToBranchval) {
		this.returnToBranchval = returnToBranchval;
	}
	public String getReturnToWearhouseval() {
		return returnToWearhouseval;
	}
	public void setReturnToWearhouseval(String returnToWearhouseval) {
		this.returnToWearhouseval = returnToWearhouseval;
	}
	@Override
	public String toString() {
		return "DashboardResults [newOrderval=" + newOrderval + ", receiveToWearhouseval=" + receiveToWearhouseval
				+ ", dispatchFromWearhouseval=" + dispatchFromWearhouseval + ", receiveToBranchval="
				+ receiveToBranchval + ", dispatchFromBranchval=" + dispatchFromBranchval + ", orderCompletedval="
				+ orderCompletedval + ", orderFailedval=" + orderFailedval + ", returnToBranchval=" + returnToBranchval
				+ ", returnToWearhouseval=" + returnToWearhouseval + "]";
	}
	
	
	
	
}
