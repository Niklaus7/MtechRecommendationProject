package stringJaccardRecommender;


import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

public class User  implements Serializable{
	/**
	 * 
	 */
	public static final long serialVersionUID = 6029875773739046075L;
	/*
	 * Name Age Educational background with stream 
	 * Gender 
	 * Preferable location
	 * Is Employed
	 * interest 
	 * Strengths
	 * Weakness 
	 * Primary technical skills 
	 * Fees range
	 */
	String name;
	int gender;
	boolean isEmployed;
	String[] interests;
	String educationalQualification;
	String educationalStrem;
	String[] recommendation;
	
	public String[] getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String[] recommendation) {
		this.recommendation = recommendation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public boolean isEmployed() {
		return isEmployed;
	}
	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	public String getEducationalQualification() {
		return educationalQualification;
	}
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	public String getEducationalStrem() {
		return educationalStrem;
	}
	public void setEducationalStrem(String educationalStrem) {
		this.educationalStrem = educationalStrem;
	}
	@Override
	public String toString() {
		return "-----------User----------------- \n name=" + name + "\n interests=" + Arrays.toString(interests) + "\n recommendation="
				+ StringUtils.join(recommendation, "\n") + "\n-----------User End-------------";
	}
	
	
	
	
}
