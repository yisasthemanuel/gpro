package org.jlobato.gpro.setup;

import java.io.Serializable;

public interface DriverComment extends Serializable {
	public static final int MAYOR_COMMENT_GRADE = 3;
	public static final int MEDIUM_COMMENT_GRADE = 2;
	public static final int MINOR_COMMENT_GRADE = 1;
	public static final int SATISFIED_COMMENT_GRADE = 0;

	public String getCarPart();
	public String getCommentDescription();
	public int getCommentGrade();
	public int getCommentSignum();
}
