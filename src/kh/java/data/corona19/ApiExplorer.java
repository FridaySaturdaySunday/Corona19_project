package kh.java.data.corona19;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kh.java.data.corona19.model.vo.Corona19Info;


public class ApiExplorer {
	public static void main(String[] args) {
		try {
			
			// 1. url 생성
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api"); /* URL */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=2HHwCrFTo5n04hIir7a1Z6EA0QjPwxWnc%2FmntbwIe32TMXH4%2B%2FeVu185T6NB8m6Kz3NkXSLAcn4mPOsfZXB3bw%3D%3D"); /* Service Key */
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("500", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append("&" + URLEncoder.encode("apiType", "UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /* 결과형식(xml/json) */
			urlBuilder.append("&" + URLEncoder.encode("std_day", "UTF-8") + "=" + URLEncoder.encode("2021-12-15", "UTF-8")); /* 기준일자 */
//			urlBuilder.append("&" + URLEncoder.encode("gubun", "UTF-8") + "=" + URLEncoder.encode("경기", "UTF-8")); /* 시도명 */
			
			
			// 2. url로 연결
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			
			
			
			
			// 3. 연결 Stream으로부터 읽기
			
			// 3. 방법 1 : Stream으로 부터 읽은 것을 console 출력
//			BufferedReader rd;
//			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			} else {
//				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//			}
//			
//			StringBuilder sb = new StringBuilder();
//			String line;
//			
//			while ((line = rd.readLine()) != null) {
//				sb.append(line);
//			}
//			System.out.println(sb.toString());
//			rd.close();

			
			
			// 3. 방법 2 : Stream으로 부터 읽은 것을 class 에 넣기
			// conn -> inputstream -> Document -> xml 다룰 수 있음
			Document doc = new ApiExplorer().parseXML(conn.getInputStream());
			
			NodeList list = doc.getElementsByTagName("item"); // <item> 와 </item> 사이의 모든 것들이 각각 하나의 element들임
			System.out.println(list.getLength());
			System.out.println(list.item(0));
			
			
			
			
			
			
			// ArrayList ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
			
			List<Corona19Info> volist = new ArrayList<Corona19Info>();
			for(int i=0; i<list.getLength(); i++) {
				Corona19Info vo = new Corona19Info();
				
				// list.item(i)의 결과를 변수명 item에 저장
				Node item = list.item(i);
				// NullPointerException : 오류난 줄에서 . 앞의 것이 null이라는뜻
				
				// item에서 첫번째 ~ 그 이후 자식 꺼냄
				Node n = item.getFirstChild(); // deathCnt
				
				while (n != null) {
					String nodeName = n.getNodeName();
					String nodeText = n.getTextContent();
					
					// ★★★★★★★★★★★★★★★★★★★★★★★★★★
					// String -> int 바꾸는 Wrapper 클래스 : Integer.parseInt("문자열") 
					// parse어쩌구는 꼭 try catch문과 함께 사용!!
					
					try {
						switch(nodeName) {
						case "deathCnt" :
							vo.setDeathCnt(Long.parseLong(nodeText));
							break;
						case "defCnt" :
							vo.setDefCnt(Long.parseLong(nodeText));
							break;
						case "gubun" :
							vo.setGubun(nodeText);
							break;
						case "gubunCn" :
							vo.setGubunCn(nodeText);
							break;
						case "gubunEn" :
							vo.setGubunEn(nodeText);
							break;
						case "incDec" :
							vo.setIncDec(Long.parseLong(nodeText));
							break;
						case "isolClearCnt" :
							vo.setIsolClearCnt(Long.parseLong(nodeText));
							break;
						case "isolIngCnt" :
							vo.setIsolIngCnt(Long.parseLong(nodeText));
							break;
						case "localOccCnt" :
							vo.setLocalOccCnt(Long.parseLong(nodeText));
							break;
						case "overFlowCnt" :
							vo.setOverFlowCnt(Long.parseLong(nodeText));
							break;
						case "qurRate" :
							vo.setQurRate(Long.parseLong(nodeText));
							break;
						case "stdDay" :
							vo.setStdDay(nodeText);
							break;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
//					if(nodeName.equals("deathCnt"))
//						vo.setDeathCnt(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("defCnt"))
//						vo.setDefCnt(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("gubun"))
//						vo.setGubun(nodeText); 
//					else if(nodeName.equals("gubunCn"))
//						vo.setGubunCn(nodeText); 
//					else if(nodeName.equals("gubunEn"))
//						vo.setGubunEn(nodeText); 
//					else if(nodeName.equals("incDec"))
//						vo.setIncDec(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("isolClearCnt"))
//						vo.setIsolClearCnt(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("isolIngCnt"))
//						vo.setIsolIngCnt(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("localOccCnt"))
//						vo.setLocalOccCnt(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("overFlowCnt"))
//						vo.setOverFlowCnt(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("qurRate"))
//						vo.setQurRate(Long.parseLong(nodeText)); 
//					else if(nodeName.equals("stdDay"))
//						vo.setStdDay(nodeText); 
//					
//					
//					vo.setDeathCnt(48);
//					vo.setDefCnt(21179);
					
					
					
					
					
					
							
					
					
					
					n = n.getNextSibling();
					
//					Node n = item.getFirstChild(); // deathCnt
//					Node n2 = item.getNextSibling(); // defCnt (X) 아님
//					Node n2 = n.getNextSibling(); // defCnt (O) 맞음
//					Node n3 = n.getNextSibling(); // gubun (O)
					
					
					
				}
				
				
				
				
				
				
			
				

				volist.add(vo);
			}
			
			// enhanced for
			for(Corona19Info a : volist) {
				System.out.println(a);
			}
			
			
			
			// enhanced for 어떻게 했더라?
			List<String> listStr = new ArrayList<String>();
			listStr.add("수박");
			listStr.add("수박");
			listStr.add("수박");
			
			for(String a : listStr) {
				System.out.println(a);
			}
			for(int i=0; i<listStr.size(); i++) {
				System.out.println(listStr.get(i)); // list.get(index); <--- 이 방법 기억!!!
			}
			
			
			
			
			
			conn.disconnect();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// 기본자세 : 메소드정의 - 첫번째 return type 확인 void 아니면 return
	
	// InputStream 형태의 객체를 주면 Document 형태로 바꿔줌
	private Document parseXML(InputStream stream) {
		
		Document result = null;
		
		// 선언은 밖에서!
		DocumentBuilderFactory objDocumentBuilderFactory = null;
		DocumentBuilder objDocumentBuilder = null;

		try {
			objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			result = objDocumentBuilder.parse(stream);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();  
		} catch (SAXException e) { // Simple API for XML
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return result;
	}
	
	
	
}
















