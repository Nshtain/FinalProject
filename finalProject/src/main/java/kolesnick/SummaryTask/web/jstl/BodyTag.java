package kolesnick.SummaryTask.web.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BodyTag extends SimpleTagSupport {

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public void doTag() throws JspTagException {
		if (num % 4 == 0) {

			try {
				getJspContext().getOut().write("</TR><TR>");
			} catch (IOException e) {
				throw new JspTagException(e.getMessage());
			}
		}

	}
}
