package com.rks.student.util;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	private static final String RESTRICTED_CHARS = "[$&<>?#]+";
	private static final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	private static final Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
	public static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static boolean isValidObj(final Object inObj) {
		if ((null == inObj)) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isEmpty(final String str) {
		if ((str == null) || (str.trim().length() == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static String safeSubString(final String str, final int begin, final int end) {
		String result = "";
		if (!isEmpty(str) && begin >= 0 && end >= 0 && begin < end) {
			if (end <= str.length()) {
				result = str.substring(begin, end);
			} else {
				result = str;
			}
		}
		return result;
	}

	public static String replaceRestrictedChars(String text) {
		if (!isEmpty(text)) {
			text = text.replaceAll(RESTRICTED_CHARS, "");
			return text;
		} else
			return text;
	}

	public static String getMaskedMobileNo(String inMobileNo) {
		StringBuilder mobileNo = new StringBuilder(inMobileNo);
		Integer[] index = { 2, 3, 5, 6, 7 };
		for (int i = 0; i < index.length; i++) {
			mobileNo.setCharAt(index[i], 'X');
		}
		return mobileNo.toString();
	}

	public static String getMaskedEmailID(String inEmailID) {
		StringBuilder email = new StringBuilder(inEmailID);
		int j = email.indexOf("@");
		for (int i = 1; i < j; i = i + 2) {
			email.setCharAt(i, 'X');
		}
		return email.toString();
	}

	public static boolean isValidInet4Address(String inet4Address) {
		Matcher matcher = pattern.matcher(inet4Address);
		if (!matcher.matches()) {
			// change_vishal
			log.info(DTF.format(LocalDateTime.now()) + " :: Invalid IP Format for " + inet4Address);
			return false;
		}
		return true;
	}

	public static boolean isValidLength(final String inStr, final int inMin, final int inMax) {
		final int inStrLength = inStr.length();
		if (inStrLength < inMin || inStrLength > inMax)
			return false;
		else
			return true;
	}

	public static boolean isValidMobile(final String inMobile) {
		Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
		Matcher matcher = pattern.matcher(inMobile);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidPinCode(final String inStr) {
		final String str = inStr.trim();
		final String rule = "[0-9]{6}$";
		final Pattern pattern = Pattern.compile(rule);
		final Matcher matcher = pattern.matcher(str);
		if (matcher.matches())
			return true;
		else
			return false;
	}

	public static boolean compareRegularExp(String inRegex, String str) {
		return Pattern.matches(inRegex, str);
	}

	public static String arrayToStringWithComma(String str[]) {
		String processedString = "";
		processedString = Arrays.toString(str).replace("[", "").replace("]", "").replace(" ", "");
		processedString = "," + processedString + ",";
		return processedString;
	}

	public static String[] commaStringToArray(String str) {
		str = StringUtils.removeStart(str, ",");
		str = StringUtils.removeEnd(str, ",");
		str = str.replace(" ", "");
		// System.out.println( "string is:" + str );
		String str2[] = str.split(",");
		return str2;
	}

	public static String removeCommaStartEnd(String str) {
		if (StringUtils.isNotBlank(str)) {
			str = StringUtils.removeStart(str, ",");
			str = StringUtils.removeEnd(str, ",");
			str.replace(" ", "");
		}
		return str;
	}

	public static String changeStringToDouble(String inStr) {
		double decimalStr = 0.0;
		if (!StringUtils.isEmpty(inStr)) {
			decimalStr = Double.parseDouble(inStr);
		}
		return String.valueOf(decimalStr);
	}

	public static Long numericValue(String inString) {
		if (isNumeric(inString)) {
			return Long.parseLong(inString);
		}
		return 0L;
	}

	public static BigDecimal decimalValue(String val) {
		BigDecimal bg = new BigDecimal(0);
		try {
			bg = new BigDecimal(val);
		} catch (Exception ex) {
			log.error(" Exception :: " + DTF.format(LocalDateTime.now()) + " :: " + ex.getMessage(), ex);
		}
		return bg;
	}

	public static String insertCharacterAtIndex(String inMacAddress, int inIndex, String inCharacter) {
		if (isNotBlank(inMacAddress)) {
			int length = inMacAddress.length();
			int loopIndex = length / inIndex;
			String[] arr = new String[loopIndex];
			int j = 0;
			int k = 0;
			for (int i = 0; i < loopIndex; i++) {
				j = i * inIndex;
				k = j + inIndex;
				arr[i] = substring(inMacAddress, j, k);
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(".");
			}
			inMacAddress = sb.substring(0, sb.length() - 1);
		}
		return inMacAddress;
	}

	public static String replaceLast(String text, String searchString, String replacement) {
		if (StringUtils.isNotBlank(text)) {
			int lastIndex = text.lastIndexOf(searchString);
			text = text.substring(0, lastIndex) + replacement + text.substring(lastIndex + 1);
		}
		return text;
	}

	public static boolean isValidCollection(Collection<?> inCollection) {
		if (StringUtils.isValidObj(inCollection) && !inCollection.isEmpty()) {
			return true;
		}
		return false;
	}

	public static String replaceSpace(String str) {
		if (StringUtils.isNotBlank(str)) {
			str = str.trim();
			if (str.contains(" ")) {
				return str.replace(" ", "+");
			}
		}
		return str;
	}

	public static boolean isContains(String inStr1, String inStr2) {
		if (isNotBlank(inStr1) && isNotBlank(inStr2)) {
			return inStr1.replaceAll("\\s+", "").toLowerCase().contains(inStr2.replaceAll("\\s+", "").toLowerCase());
		} else {
			return false;
		}
	}

	public static String removeStringFromStartAndEnd(String data, String str) {
		if (StringUtils.isNotBlank(data) && StringUtils.isNotBlank(str)) {
			data = StringUtils.removeStart(data, str);
			data = StringUtils.removeEnd(data, str);
		}
		return data;
	}

	public static int[] convertStringArraytoIntArray(String[] strArr) {
		int[] intArray = null;
		if (strArr != null) {
			intArray = new int[strArr.length];
			for (int i = 0; i < strArr.length; i++) {
				intArray[i] = Integer.parseInt(strArr[i]);
			}
		}
		return intArray;
	}

	public static boolean isStringNumeric(String str) {
		DecimalFormatSymbols currentLocaleSymbols = DecimalFormatSymbols.getInstance();
		char localeMinusSign = currentLocaleSymbols.getMinusSign();
		if (!Character.isDigit(str.charAt(0)) && str.charAt(0) != localeMinusSign)
			return false;
		boolean isDecimalSeparatorFound = false;
		char localeDecimalSeparator = currentLocaleSymbols.getDecimalSeparator();
		for (char c : str.substring(1).toCharArray()) {
			if (!Character.isDigit(c)) {
				if (c == localeDecimalSeparator && !isDecimalSeparatorFound) {
					isDecimalSeparatorFound = true;
					continue;
				}
				return false;
			}
		}
		return true;
	}

	public static boolean matchPattern(String regex, String data) {
		try {
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(data);
			return matcher.matches();
		} catch (Exception e) {
			log.error("Getting Exception in matchPattern: ", e);
		}
		return false;
	}

	public static String removeMultipleSpaces(String str) {
		if (StringUtils.isValidObj(str)) {
			StringTokenizer strToken = new StringTokenizer(str, " ");
			StringBuilder sb = new StringBuilder();
			while (strToken.hasMoreTokens()) {
				String subStr = strToken.nextToken();
				if (StringUtils.isValidObj(subStr) && subStr.length() > 0) {
					sb.append(subStr + " ");
				}
			}
			return sb.toString().trim();
		} else {
			return str;
		}
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

}
