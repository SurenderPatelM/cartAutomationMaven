package Utility;

public class ActionStatus {
	public Boolean getActionStatus() {
		return actionStatus;
	}
	public void setActionStatus(Boolean actionStatus) {
		this.actionStatus = actionStatus;
	}
	public String getActionResultMessage() {
		return actionResultMessage;
	}
	public void setActionResultMessage(String actionResultMessage) {
		this.actionResultMessage = actionResultMessage;
	}
	public Exception getActionException() {
		return actionException;
	}
	public void setActionException(Exception actionException) {
		this.actionException = actionException;
	}
	private Boolean actionStatus;
	private String actionResultMessage;
	private Exception actionException;
}
