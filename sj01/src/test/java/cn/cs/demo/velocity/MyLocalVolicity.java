package cn.cs.demo.velocity;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class MyLocalVolicity {

	public static void main(String[] args) {
		//Velocity.init();
		Velocity.init("mylocalvelocity.properties");
		VelocityContext vc = new VelocityContext();
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		String dateStr = df.format(date);
		vc.put("username", "xiakun");
		vc.put("dateStr", dateStr);
		
		Template t = null;
		
		t = Velocity.getTemplate("vm/first.vm", "UTF-8");
		StringWriter sw = new StringWriter();
		t.merge(vc, sw);
		
		System.out.println(sw.getBuffer().toString());

	}

}
