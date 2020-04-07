/*
 * Copyright (C) 2019 by GMO Runsystem Company
 *
 * Create clas Staff
 *
 * @version 1.0
 * 
 * @author BienPD
 *
 */
package fresher.bienpd.behavioral.strategy;

public class Staff {

	private int id;
	private String fullname;
	private GoToWork goToWork;

	public Staff(int id, String fullname) {
		this.id = id;
		this.fullname = fullname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public GoToWork getGoToWork() {
		return goToWork;
	}

	public void setGoToWork(GoToWork goToWork) {
		this.goToWork = goToWork;
	}

	public void goToWork() {
		goToWork.go();
	}

}
