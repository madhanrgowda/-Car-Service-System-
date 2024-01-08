import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
    private String mname;
    public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	private String mtype;
    private String carnum;
	private String aun;
	private String apwd;
	private String cname;
	private String cun;
	private String cemail;
	private String cpwd;
	ResultSet res;
	Connection conn;
	private PreparedStatement pr;
	
	Model()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connecting to a selected database");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/CarService","root","root");
			System.out.println("Connected database successfully");

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	int adminLogin()
	{
		try
		{
			String sql="select * from AdminDB1 where un=? and pwd=?";
			pr=conn.prepareStatement(sql);
			pr.setString(1, aun);
			pr.setString(2, apwd);
			
			ResultSet res= pr.executeQuery();
			if(res.next()==true)
			{
				return 1;
			}
			else
			{
				return 0;
			}

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	int customerCreateAccount()
	{
		try {
		String sql="insert into CustomerDb values (?,?,?,?)";
		pr=conn.prepareStatement(sql);
		pr.setString(1, cname);
		pr.setString(2, cpwd);
		pr.setString(3, cun);
		pr.setString(4, cemail);
		
		int x=pr.executeUpdate();
		return x;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}
	int customerLogin10()
	{
		try
		{
		
		String sql="select * from CustomerDb where cun=? and cpwd=?";
		pr=conn.prepareStatement(sql);
		pr.setString(1, cun);
		pr.setString(2, cpwd);
		
		 res=pr.executeQuery();
		 if(res.next()==true)
		 {
			 cname=res.getString("cname");
			 return 1;
		 }
		 else
		 {
		return 0;
		 }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public String getAun() {
		return aun;
	}

	public void setAun(String aun) {
		this.aun = aun;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCun() {
		return cun;
	}

	public void setCun(String cun) {
		this.cun = cun;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	
	int updateDetails9()
	{
		try {
		String sql="insert into cardetails values (?,?,?,?,?)";
		pr=conn.prepareStatement(sql);
		pr.setString(1, cname);
		pr.setString(2, cun);
		pr.setString(3, mname);
		pr.setString(4, mtype);
		pr.setString(5, carnum);
		
		int x=pr.executeUpdate();
		return x;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return 0;

	}
	
	int carcheck1()
	{
		try
		{
			String sql="select * from cardetails where cun=? ";
			pr=conn.prepareStatement(sql);
			pr.setString(1, cun);
			res=pr.executeQuery();
			if(res.next())
			{
				mname=res.getString("mname");
				mtype=res.getString("mtype");
				carnum=res.getString("carnum");
				return 1;

			}
			else
			{
				return 0;
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
