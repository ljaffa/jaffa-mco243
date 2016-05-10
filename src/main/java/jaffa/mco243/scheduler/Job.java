package jaffa.mco243.scheduler;

public class Job implements Comparable {

	private Priority priority;
	private Priority dynamicPriority;
	private int timeLeftToRun;
	private Long lastRanAtTime;
	private String name;
	private JobType type;
	private JobState state;
	private Long deadline;

	public Job(String name, Priority priority, JobType type, int timeLeftToRun,
			Long deadline) {
		this.name = name;
		this.priority = priority;
		this.type = type;
		this.timeLeftToRun = timeLeftToRun;
		this.deadline = deadline;
	}

	public Long getDeadline() {
		return deadline;
	}

	public void setDeadline(Long deadline) {
		this.deadline = deadline;
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

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

}
