/**   
 * Copyright © 2015 Liuyunguo. All rights reserved.
 * 
 * @Title: Algorithm.java 
 * @Prject: SMXAlgorithmVerification
 * @Package: com.yinwenqi.db 
 * @Description: TODO
 * @author: Wither   
 * @date: 2015年11月29日 下午8:22:16 
 * @version: V1.0   
 */

package com.yinwenqi.db;

/**
 * @ClassName: Algorithm
 * @Description: TODO
 * @author: Wither
 * @date: 2015年11月29日 下午8:22:16
 */
public enum Algorithm {

	SM2(0), SM3withSM2(1);

	private int typeCode;

	private Algorithm(int typeCode) {
		this.typeCode = typeCode;
	}

	public int getTypeCode() {
		return this.typeCode;
	}

	public String getName() {
		return this.name();
	}

	@Override
	public String toString() {
		return this.ordinal() + ":" + this.typeCode;
	}

}
