package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProductController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {

		/**
		 * well , the git and intelliJ is working together now
		 * let us try to push a new branch
		 * somebody tell me that you had to create a new branch
		 * to push the changed files. is that true?
		 */
		return "/jsp/ProductForm.jsp";
	}
}
