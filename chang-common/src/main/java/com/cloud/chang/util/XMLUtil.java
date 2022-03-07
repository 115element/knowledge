package com.cloud.chang.util;

import java.io.ByteArrayOutputStream;

import com.ximpleware.AutoPilot;
import com.ximpleware.FastLongBuffer;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;

public class XMLUtil {

	public static String getPartXml(String xml, String rootNodeName) {
		VTDGen vg = new VTDGen();
		String partXml = "";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {
			byte[] xmlBs = xml.getBytes();
			vg.setDoc(xmlBs);
			vg.parse(true);
			VTDNav vn = vg.getNav();
			AutoPilot ap = new AutoPilot(vn);
			ap.selectXPath("//" + rootNodeName);
			FastLongBuffer flb = new FastLongBuffer();
			while (ap.evalXPath() != -1) {
				flb.append(vn.getElementFragment());
			}
			int size = flb.size();
			for (int j = 0; j < size; j++) {
				bos.write(xmlBs, flb.lower32At(j), flb.upper32At(j));
			}
			bos.flush();
			partXml = bos.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partXml;
	}

	public static String getTagText(String xml, String tagName) {
		VTDGen vg = new VTDGen();
		String partXml = "";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {
			byte[] xmlBs = xml.getBytes();
			vg.setDoc(xmlBs);
			vg.parse(true);
			VTDNav vn = vg.getNav();
			AutoPilot ap = new AutoPilot(vn);
			ap.selectXPath("//" + tagName);

			FastLongBuffer flb = new FastLongBuffer();
			while (ap.evalXPath() != -1) {
				flb.append(vn.getContentFragment());
			}
			int size = flb.size();
			for (int j = 0; j < size; j++) {
				bos.write(xmlBs, flb.lower32At(j), flb.upper32At(j));
			}
			bos.flush();
			partXml = bos.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partXml;
	}

	public static void main(String[] args) {
		String xml = FileUtil.file2String("C:/work/tools/neon/workspace/broadband-cn-api/1.xml");
		String partXml = getPartXml(xml, "ListOfAssetMgmt-Label");
		System.out.println(partXml);
	}

}
