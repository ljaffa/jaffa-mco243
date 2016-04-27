package jaffa.mco243.scheduler;

public class Job {

	private Priority priority;
	private Priority dynamicPriority;
	private int timeLeftToRun;
	private Long lastRanAtTime;
	private String name;
	private JobType type;
	private JobState state;

	public Job(String name, Priority priority, JobType type, int timeLeftToRun) {
		this.name = name;
		this.priority = priority;
		this.type = type;
		this.timeLeftToRun = timeLeftToRun;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Priority getDynamicPriority() {
		return dynamicPriority;
	}

	public void setDynamicPriority(Priority dynamicPriority) {
		this.dynamicPriority = dynamicPriority;
	}

	public int getTimeLeftToRun() {
		return timeLeftToRun;
	}

	public void setTimeLeftToRun(int timeLeftToRun) {
		this.timeLeftToRun = timeLeftToRun;
	}

	public Long getLastRanAtTime() {
		return lastRanAtTime;
	}

	public void setLastRanAtTime(Long lastRanAtTime) {
		this.lastRanAtTime = lastRanAtTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public void decrementTimeLeftToRun(int time) {
		timeLeftToRun -= time;
	}

	public boolean isFinished() {
		return timeLeftToRun <= 0;
	}

}
