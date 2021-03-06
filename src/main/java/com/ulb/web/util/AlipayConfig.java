package com.ulb.web.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.ulb.core.statics.Constant;

/**
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
//	public static String partner = "2088121767113621";
    public static String partner = "2088121767113621";
	// 收款支付宝账号，一般情况下收款账号就是签约账号
	public static String seller_email = "caiwu@wannengxiaoge.com";
	// 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public static String seller_id = seller_email;
	// 商户的私钥
	public static String KEY = "epucylexxn22qymeasnxswh7i9pnjq1t";
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "d:\\";
	
	// notify_url 交易过程中服务器通知的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	public static String notify_url = "";
	// 支付宝的公钥，无需修改该值
	public static String ALIPAY_PUBLIC_KEY_APP  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	// 付完款后跳转的页面 要用 http://格式的完整路径，不允许加?id=123这类自定义参数
	public static String return_url = "";

	// 网站商品的展示地址，不允许加?id=123这类自定义参数
	public static String show_url = "";
	 
	//收款方名称，如：公司名称、网站名称、收款人姓名等
	public static String mainname = "";
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	


	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	
	//访问模式,根据自己的服务器是否支持ssl访问，若支持请选择https；若不支持请选择http
    public static String transport = "http";
    
    // 签名方式 不需修改
	public static String sign_type_md5 = "MD5";
	
	public static String sign_type = "RSA";//扫码支付
	/**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET          = "GBK";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";
    /** 服务窗appId  */
    public static final String APP_ID            = "2016011201085543";
    
    //TODO !!!! 注：开发者必须设置自己的公钥 ,否则会存在安全隐患
//    public static final String PRIVATE_KEY       = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIOdoCVrr/bWnmPEaDYoPJSH7cfrtGBTMFQjeE2v73GlTEWPjJNs7T6aTPcmXNeIiyLmLzOL8AgArrn2pjgpw04nIetW3ZaiczrRzK3E+zadfEDf4KighWgGeYVgLRfNYirDBnaqQMk3XcvDhYoF6hTZWg4q8ABNcvXTI4FLGWtVAgMBAAECgYBdbCp7xWee55KAMK7kGkV+DMo8iVN8uC/q2U6QnlxxJ6rvCUj4cG4qbK5LFID8QKC6gfdpOGCF3a4otCoiXYqSTxEUuntEqS5rtovxvW/fP3TPLZ3DFFIwt2F7np6dvRQ5sLqRvHWNS4r716XDXfxV/BsflEwaaxAOZ4/6uG1nVQJBAMC28NxyRb/9MdrEufKDjMcuZEnw1TjSJVyuKlS8eSdTvq12viH+ZWeFHYcq9U8ZVN0vKEWUBmCHV8qZlyKS2RMCQQCu1j8cMG0bkQuB8WHtNvs80lRXqIMvfsyDco06JjAdUJfULs187qwSrMN2nhwWQf+8gFSPv7YFfqcfAYHRF173AkEAqVxcwq9eYwJl3OfErr8zahx4II8ZI61zDkc1hnB4XLp5OULAh2llvps6vv5exVvyu8tkrfkPvadT3QYrz0OUpwJBAK2kSV+01Ng5EQXId6rCHXoFpxC8YzYLqBCw94SWItkqjvCEXz/CR5Hwldy8IUcV22kax2FRVPVWGaMYuxawMHcCQGir3STI2uP/RIcShyA12ZfwzYRbJqtAVt3C991l8piDrf5n0lxtSP1TeFZ/L5zjDjCGEveNa5HJuj4re8xhyps=";
//    public static final String PRIVATE_KEY       = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK3nOBSC9RJVFT52"+
//    "49mEKt0vXTKqgmrzeQwdsx35EuV7+b7sOKSOh3wukvvcRKaAwa6VbGzAC9Is2DP3"+
//    "wOpfXMcmbA2PSxNcw5Oo7fyLdVUAaXrovuFddMq/Zyb04uy0qssgSkofR+SFyd8t"+
//    "JApBeMwWhnG7qBIHufdb4NPqOPs9AgMBAAECgYEAokiRluKWnKL1jjMYcdXawkn+"+
//    "6NchmXjXzyywCBp1Pd4xs69xNG8llAdKduqYzeB93dPnOJ0G6v2aTPS4/H49brhj"+
//    "yZfFk+M7IQFZVwIbfBiRY7JSsJWBdfFe2ad2ecr+80jWejZgACkkYxcWjH0MIV/Q"+
//    "M6vsrqjGjV07F2VCnUECQQDivs5DlD2sipbOYvG/XRaYoQURONkSYAjwXZr+0M5T"+
//    "9OWGpzwnSvToOVAMbD9pL7eeaFfr4rPF2/Rro6datx7lAkEAxFcVzqKeTCRxQs/b"+
//    "Rej7/fUyqOQpIGKKl/B+f4SMBmBLYobSEtXauSFucDNvx1A1/5MMTrO8HYda1Z1n"+
//    "oVbNeQJAKgh/Ci4P5M1oOWhEMlpaVv76hn/IVcyxu4VOt1AT/6JVbknQL+SIVAhT"+
//    "24mxk5lB676iFdtXwiUNQWr8Gif6NQJAMmxnFlVfMBDf4Ze+KZsnNFaHdyZ5hW6p"+
//    "R1IlOpyQ1YZfdeNICjxP2uHCGiCroVVxOLzMGV5BfpfndRripWXEiQJAYqD2Q+mV"+
//    "vAFaeMS7lXg4d/qE72QUauJxeNGKwnNsPkDANouUUqYbGcQpWmkH/3YrZRhJGJAh"+
//    "eqUNHjHntGU+Ig==";
//    public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAI62DrDqaKQbEQWhi2uWrjO3F1hLwx+INc8McuE8s0TM5dP/YmSe9IFOuzCYyu/hA93SGKFdNZQ9QhgcOHukICih2ShTe6eD3MhSLkrh3e8Wj0zJp17KLIOLc3Hn9jiD5JKtbcIVVoTAbQXyTlfj02jb3C0YLYGR4hX5r1ItYYF1AgMBAAECgYB0CTWixcX1gQhzIqnA/hCAfiNeKKPrtI3D3uRdnURJ8awBlspC9DfsF77+QY3oQ3YoW1aphac19CUUg4WtioKWMB/ALhJLxKowvCo3CIP/SDxiYCRJJN/TlcpvFNJDTsQn3PRcuRPzXTzgNkldyh5M3PTKhfEYyWptKQRQuUOEQQJBAMU6+8NVzoqj5C8uPT0fHhQNL2Y7SII+G+1wjGbgUzwyCZPSULCEjvGGz0w1u9lvz5RDMjGLd92U5vs0zgcQ0XECQQC5PESzOcL5s+3OSdgt3uoCdP8YdGgPyPfqz4zT3BsIqNyZ0KpF69kGhpClBaMyTAFrI/jdf0uhJ+VG1PrkQu5FAkEAsU+To0pzAsTQkXH6cAaXneM0p63IQ/7eUJoMPziQ298IKTK8g9TIRW6y0orENHiGn33BlDUUL8p71X7lcgi2oQJANRVFZsstyds7UfutfO+9xfh7RinNzIA+M8dIx0nzYVbq6RV4RlNhPVKAzxm/e+F2IpsLbYZWSReix9qvD4zytQJBALYX9duRWXYkcyNhHqPc1Z9Xk7fJ0wo7oOnizHOwGvkSX9R8QY3eqTzOTaFbcQ5y1Z4O8X6RHteXBsOeOclTsQc=";
    public static final String PRIVATE_KEY = Constant.PRIVATE_KEY;
//    public static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIpIr1G9mkZsYPp5k2T0E+O4VViTDhO2SIVQnF/OIJ+ffA5z8zdk95GLhGpusqpi1D31dDN3oFqlQ502NYSZEdOPhxXPvbwYaOuzogVaAecLXPZSoD/Mi3Kutsn8WCW27Jq9beYis+M4IuJ7ug2y35PkDLg10S1tylv1ntAtWm9zAgMBAAECgYB7pqbuZqZPFpZZIuFDwmUOmUPnogdSZQrP+tb5bC4LzeZ2XgQ7olMlmCXdrgKhDSJQDO3NH8kJhQHC0DhmyyD+Q/KyuJEaVjeLXIkYF+TXbH63mtt3wuGbj0KAleKGJKkSBbQl+DgzVx3y5bUI0qxMj/XbdNEwVUhoeyVXESJqkQJBANCHWhED+EU7bXETTmKIWJhTqNNHl8tQUQeikkugp9haeP7TRs8F7OMQ72jDCINqhvXsCmJRPKVhjYl+ko7rqS0CQQCpw5pkB1PEs4BtKBjXh1QrGtQZm++7ttXY9SrRs9Suz0LNNhsQ5xPJkjLNdFTS0tyqmSnX8+jAZzVhRoZedp8fAkEAxEThLOrDnsYUeD1npa4XVShI2rOj16U83ybQ84W+9RASmiZZmzlEgWPLMpt/Q9HcPVNxYqB7qF1tTmBnqUV98QJARcloJWixsfHMgJL0K12xZwrfWCu3UGZn4IlgcdZIPxhqsKtmUvt7MejMw5Ln78bI+cR+5AybiMSkt/li8WA4JwJBAMbrkl8NHfvHuFz7TBu14biGl2MImKuQ2dJPCOCRb4kOc7MrmBTdK1G9G76gMeWZ0yehNdcegHd7RzXXEoFULa8=";


	//TODO !!!! 注：开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCDnaAla6/21p5jxGg2KDyUh+3H67RgUzBUI3hNr+9xpUxFj4yTbO0+mkz3JlzXiIsi5i8zi/AIAK659qY4KcNOJyHrVt2WonM60cytxPs2nXxA3+CooIVoBnmFYC0XzWIqwwZ2qkDJN13Lw4WKBeoU2VoOKvAATXL10yOBSxlrVQIDAQAB";
    /**支付宝公钥-从支付宝服务窗获取*/
    public static final String ALIPAY_PUBLIC_KEY_QR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
    
 // 调用的接口名，无需修改即时到账
	//public static String service = "create_direct_pay_by_user";
	public static String service ="mobile.securitypay.pay";
	// 支付类型 ，无需修改
	public static String payment_type = "1";
	// MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    public static String key = "";
}
