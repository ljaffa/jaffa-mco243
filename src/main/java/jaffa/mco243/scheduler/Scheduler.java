package jaffa.mco243.scheduler;

import java.util.List;
import java.util.Random;

public abstract class Scheduler implements Runnable {

	protected List<Job> jobs;

	// maximum amount of time each job runs for
	public static final int TIME_SLICE = 10;
	// amount of time it takes to switch jobs
	public static final int OVERHEAD = 1;

	protected int numJobsCompleted;
	protected int totalTime;
	protected Random rand = new Random();

	public Scheduler(List<Job> jobs) {
		this.jobs = jobs;
		totalTime = 0;
		numJobsCompleted = 0;
	}

	@Override
	public abstract void run();

	public int executeJob(Job job) {
		job.setState(JobState.Running);
		job.setLastRanAtTime(System.currentTimeMillis());

		int actualTimeSlice = computeActualTimeSlice(job);
		job.decrementTimeLeftToRun(actualTimeSlice);

		if (job.isFinished()) {
			jobs.remove(0);
			numJobsCompleted++;
		} else {
			job.setState(JobState.Ready);
		}
		return actualTimeSlice;
	}

	public int computeActualTimeSlice(Job job) {
		int timeLeftToRun = job.getTimeLeftToRun();
		int actualTimeSlice;
		if (job.getType() == JobType.IO) {
			actualTimeSlice = Math.min(timeLeftToRun, rand.nextInt(TIME_SLICE));
		} else {
			actualTimeSlice = Math.min(timeLeftToRun, TIME_SLICE);
		}
		return actualTimeSlice;
	}

}
