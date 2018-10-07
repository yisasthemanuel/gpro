package org.jlobato.gpro.update;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author JLOBATO
 *
 */
public class UpdateServiceManager {

	private static UpdateServiceManager instance;

	/**
	 *
	 */
	ExecutorService pool;

	/**
	 *
	 * @param poolSize
	 */
	private UpdateServiceManager(int poolSize) {
		this.pool = Executors.newFixedThreadPool(poolSize);
	}

	/**
	 *
	 * @return
	 */
	public static UpdateServiceManager getInstance() {
		return instance;
	}

	/**
	 *
	 * @param poolSize
	 * @return
	 */
	public static UpdateServiceManager getInstance(int poolSize) {
		instance = new UpdateServiceManager(poolSize);
		return instance;
	}

	/**
	 *
	 * @param handler
	 */
	public void updateWeatherService(Runnable handler) {
		this.pool.execute(handler);
	}


}
