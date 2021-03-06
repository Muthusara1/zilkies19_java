package io.ztech.fitnessapplication.ui;

import java.util.Scanner;
import java.util.logging.Logger;

import io.ztech.fitnessapplication.DriverClass;
import io.ztech.fitnessapplication.beans.FoodLog;
import io.ztech.fitnessapplication.beans.UserAccount;
import io.ztech.fitnessapplication.beans.UserPhysicalDetails;
import io.ztech.fitnessapplication.constants.DisplayStringConstants;
import io.ztech.fitnessapplication.service.FoodService;
import io.ztech.fitnessapplication.service.UserPhysicalDetailsService;

public class TrackerUI {
	private static final Logger logger = Logger.getLogger(DriverClass.class.getName());
	private static final Scanner sc = new Scanner(System.in);

	private static final FoodService foodObj = new FoodService();

	public boolean weightTracker(UserPhysicalDetails stats) {
		// when weight is uploaded, stats must be updated to change bmi,bmr accd
		logger.info(DisplayStringConstants.WEIGHT);
		float weight = sc.nextFloat();
		stats.setWeight(weight);
		boolean flag = new UserPhysicalDetailsService().trackWeight(stats);

		if (flag) {
			logger.info(DisplayStringConstants.DONE_MSG);
			return true;
		} else {
			logger.info(DisplayStringConstants.NOT_DONE_MSG);
			return false;
		}
	}

	public boolean foodTracker(UserAccount account) {

		FoodLog foodLog = new FoodLog();
		foodLog.setUserName(account.getUserName());

		logger.info(DisplayStringConstants.MEAL_TIME);
		foodLog.setMealTime(sc.nextInt());

		new DisplayUI().displayFood();

		logger.info(DisplayStringConstants.FOOD_ID);
		foodLog.setFoodID(sc.nextInt());
		logger.info(DisplayStringConstants.QNTY);
		foodLog.setQuantity(sc.nextFloat());

		int logID = foodObj.getLogID(foodLog);
		int mealID = foodObj.getMealID(foodLog);
		// System.out.println(logID+" "+mealID);

		foodLog.setLogID(logID);
		foodLog.setMealID(mealID);

		return new FoodService().enterFoodLog(foodLog);

	}

}
