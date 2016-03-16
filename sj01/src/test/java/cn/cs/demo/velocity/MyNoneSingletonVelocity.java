package cn.cs.demo.velocity;

import java.io.StringWriter;
import java.util.Date;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class MyNoneSingletonVelocity {

	public static void main(String[] args) {
		VelocityEngine ve = new VelocityEngine("mylocalvelocity.properties");
		VelocityContext vc = new VelocityContext();
		vc.put("username", "刘军");
		vc.put("dateStr", new Date());
		
		Template t = ve.getTemplate("vm/first.vm", "UTF-8");
		
		StringWriter sw = new StringWriter();
		t.merge(vc, sw);
		
		System.out.println(sw);
	}

}
