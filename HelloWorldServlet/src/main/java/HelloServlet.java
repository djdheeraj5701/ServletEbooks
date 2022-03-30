

import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String img_url="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAKIAdwMBIgACEQEDEQH/xAAbAAABBQEBAAAAAAAAAAAAAAAAAQMEBQYCB//EADsQAAIBAwMBBgQEBAUEAwAAAAECAwAEEQUSITEGEyJBUWFxgZGxFCMyoRVSwfAWM2Jy8SVTktEkJkP/xAAYAQEBAQEBAAAAAAAAAAAAAAAAAQIDBP/EACARAQEAAgMBAAIDAAAAAAAAAAABAhEDEiExIjITQWH/2gAMAwEAAhEDEQA/APXKQuoOCwzxxn16UtNfhoe8eTuwHcqzsD1K9PpWG3bOilgWUFRkjPl/YNAljLBRIpZhkDPJHwriS2glLNJGGLoUYnzU9R8KUW8KzCYRr3gTYH89vp+1B13secb1znGNw60nex/zr+rb+ofq9PjXJt4SeY1Pj3/P1/YfSuVs7ddm2MDbIZF5P6j1Px6/WgdaWNWKs6qQMkFgMD1pDNEN2ZEyv6huHHTr9RQ0MbliyAl1Ct7gHOP3ps2dsWkcxLmTBc564ORQO94ni8S+EZbnpxnmkE8RGRKmNu79Q6evw4oMMf5mU/zBh+evGPtTYs7dVKiJQpQRkeW3nj9zQOGaMMVMiZGMjcOM9KUSIW2h1Jztxnz9Pjwa4e2gkRkeMFXUKwPmB0H70G2hLFu75L7yQT+rGM/Q0HYljO3DqdxIXnqR6UqOki7o2DL6qcimxbxBkbZyjl1OTwT1pbeCK2iEUCBEBJAHvyaByiiigKKKKAxXMiCSNoyzKGBBKtgj4HyNRNY1KPSrMXMoBUyJH4nCAFjjJY8Ac1Fg7R6ZLbxySziEvEZSkg/SAC3JGR0BIAPIGRxQVkP8WsrNZYo7y4uM3ZxcNI4GHxECM+a/XGalw6lqq6ja2U8EOZmlDSBCm1IpCC+0nOGUpt9CfMVOj13TZBJtuDmMEspicHg4IxjJIJHA55HrTU/aDS4gkqzxuD3W5xwESQjDFjxjzx7UEN2uf41MJzqne/iF/DiBPyO42rncf09d2cnd6eVQoNS7Q2eiQiW0kuLpIo2z+FkJf8rcVbnO7dkbvXyFXd3r1jaxysXYyRxiUxlGUlcr6jy3KSOozSHXrAPzKe7CBt+1s7t5TZtxu3ZHTGaCBc6tq9v3rzwRRxNKUjdoG/LAm2AnLDeSuGAGPnTFrrmuXKQSRWMTRyWxlDdzIVY7XwcjOOQo29TnjyqfrXaCxsLOCZ0W6t7mJ5E2spDqoB8IP6icjCjk9KlfxvS4xIv4pV7ohWUKeucYAA5weDjOPOgNG1B7yJY7qKWK7WMSOrQNGNpZlBGc9ducZzgjgZqyIBx7VXXes2dum5ZBLJ3gj2L1P5iIfoZF+tFjren3vdCCVg0zOER4ypO1ipPsMjjNBY0Uh5paAooooCjOM56UVRdpNZfTXjih2d44OSwyAPlz61LdLJtbXdrDdxrHcIHRZFcD3ByKgDs7pgGO4f8Aye5P5rcpt2jz6heM1z2e1RtRt373Z3iYLBAQMEcdfn9Kn395FYwGa4YqgOMhSab82aRp9EsLgsZInO4s2RIwOSysfP1RfpXP+HtKNl+Ce0Else7zFIxYHYMLnJ5xU+CZZ4lkQ5U5wSCPOnOhANBUt2b0x3d3jmZ3j7tma4csRhR1znPgXn29zXT9n9OdNrxyOSd29pWLbtxbdknrkn5cdKtB0FHnj1qog3GjWNxBDDLExSCMxx4dgVBxyDnOfCCD1GKZl7PabILlTE4W5JMgEhAJJ3H6k5q0ozioKz/D+n9+0pjlJJDYMzYB3I/Azxlo1J9ce9dpotlHNBMqyboJHljzIxCs5JPyyTxVhVXY6o9xqc1q0IVVzg854PU8dKW6WTa0NLSZ86B1qoWiiigKyJQ6r2rZWyY4HDMvOMJ0+ea146isRbHV47u6u9PtxKszld5UHODzjnPX7Vzyvum8Yc0f/pXaZ7JvCkrMBkjHPK8eXTHzpO1d3dySvbSAx2wfKsFxuIUcZ+tQdVbU1uo7+8iMc3hCyINoyvPzOAOeOlXXaucXGk2VxGVIZlfDDjkHy8/hWf6rcnsHZi/vJD3M67bZIchzGRznnmuJ9dvL2Vo9Lt/Cp5BQksvrjoPh/wAVKl7z/BiiEkHuF+OMjd+2aXse8T6fIq7e+3+MDr04/v1zT/Nnn1xYa3Ml0LXUY9pyB3nTnjy/9V1q+szWWpdwio0a7WbPUjqQPLOKi9sGjee3jVx3m07sDJx5f1pi+V5O0VslyoJ/JDejHC5+/lUuVnizGX1JfXdQR1d7NYoWOcMDyvH1NOya/cTeKytS6IMyEgkj6cf30qd2lUfweZsAlSrDPxFNdlB/0snGcyHr8qvvbW0867060TWGvneKaILJjcpRsgjP3pNP1J7nU5IDFGoAO5l4JwSPnVfpyrH2nZFG1e8kG0k8YBwfv9aNHZ/4vc7FG7Y5XI9/tUmV8XrPVhqGrmOVoLVA8oOMk+ecYxRZ6rPuxdxBQxyMAggfA1G7NqhuJXcZmA4Lcj3x71d3CwNgz7OOQTxV9v5bZ8n46Pg5GQcg9KKSMKEAjxtxxiiurmU+Rpm0gW2t1hU52+fr5/enqbkkVCASASf2pqfRE1rTxqVk0Jba3VWz0PSoZ0RpdHWxuJE3RyF4nUcAZzjH1Hwq7HOfT41w7rHjOFycfGpZDdU2i6Pc6e799OkkTKV7td2Bk+/tmo9z2fngn73TZ2XJOcuQ3Jz18wK0Yo4FS4xqZ2KLT9CZJlub+YyOp3bd2QW9T9BS3ekTT60l9vXuw6NgnBG3GftV1JIsYG5lXPA3HGaVSGAcEEEZBp1nw7X6iatave2ElvGQrORgnywQa40WzaytGhk27jIW8PTn/irDFGP25zV1N7Z35pS2mmTRa016zKyF3bg8jdnH3NGlaZPaX7zyFWUhsEHpk5H9auRjNHT1qdY1cqo77RpFuGubB9shbdjO3Hriurewu5pVkvJGIGcbmBJGfLHAq6HWgDFT+ObX+S6KqhVCr0HSiiiujmKyXbQ/nQoDn8pjj355rW1je3TKLq2DZz3Z+mef6Vjk/VvD9mvjPgGRj4Vl+27kPZIpfxb+Aep8OPuPqaji77UjpHMuOcdwpJGRx08qrdYm1GaW3GqK6HB2d6gXAyM4PmOnNYyy/HTeGPrfWpH4OE5AAjX7ClhuYZiFilRjzgBhmqfVLK7vEtu7uoo7SONd25yM8ck49B0GfWqXV7SysI45rG/76XcF2B1PhA4PhxjoK1c7GZhKte2Z/wDhQMCVy5AOfPHT34zVppTxx6VZkkKpiXbk9ePvWf124kutF0yeYKZCWZ88ZwMZrvTNAkv7KGe8upEJTEagZIUjA6+1Y7XvuN3GddVqgQy5BGMZ61U2Vhdw6xNdSzK8LFyo3HPPQY9gP2qr0ia403W206eXfGWKgYPJIyCKa08STa5ewh8g98BkcAnIq3KXSTDW13d6q0WqxWUaoQ20E7vEpOc/t96tjxnIrBy2E8epLZPKpkOArZIUcdf2/are8F1pWlQ2xkBZ5G3OpOMY6Z6jNSZ321bxzzTRhlLYyMjypRWZt9JSSGKWxvlacgFld+n0561o4N4iTviDJjxEdDXTHK37HPLGT4cooorbAPtWL7c4F9ajwA93ldx6nd0/fz9K2hqHd2FrdurzwK7gbQxHODnI+9Zym41jdVLUeEckYJrI9uWbv7MBmWMK+/Bx/Lx961wAAx0/aol5YW140bXUSyNHnYSORyDwflTKbmjG6rL6+TNqdnBdySLa9yh4Bwg829651tNHW3iGnIGl387S3C4PBz71rLmxtbpUWeFHVBhQR0HxppdKs0iKLCoB5OOM/PyrFwtbmcZ3U4Q2haRGBu5bwg5Jz6cf3mrLRdbtksI4bksjwqFOFJBHQHj5VZyabaS28dvJEGjjBC8kYzwcU3Lo9hKyl7dcoNoOSOP6/PNOuUu4dsbNVSWBbUe0f4pVKopDg+YUcD60uiD/AOx3DbQOZMEHpyeorR2trDaR7LeNY/XHU/Pr9aag062huDPGhDkknk4yfanS7lO81VDqLC37RrPNlEDI2/bnjHl8qttQvbCW0QzI88UhIUop6j+tSL3TrW9YNcRBmAxnJBFKmn2y2gtSm+IHIDsSc062bO0umf1K1s7eNbixutzMc4BBIGDz7CtDpcrzWMMkpJdl5J4z71FGh2O/c0RPOcFjj6VZqoUYAAA6ADFMMLLszylhaKKK6uQooooEbpS8nz60UYxQMrdQGV4xKodGCEE45IyMZ6/L0rmK8tpN+JV8Dsh3cDKnBHPpj+8imnSwW6COsQn8J5HJO47Tn4lvmfeo0cmlXYbfEm4SMNknUk8nHPnuoJ8l1Ajxq0qDvCQvPBwMnmk/GWzSvAZlEkeNwbw44z5+1Qo3064hh2RmTldmODubx9RgAgrn2I45p7dps2SXhLOd5DOP1YAz19gPlQTDNF/3I/8AyFNG9txcNAZQJFyCpB/0+3+ofX6QAdJkVF7hQssSH9O0bWDMM8+Wxvh86dkfSbglpe5LNlSzHGQPD19OetBYqVYZUhvLg5qtvNbsrVipZpGHXZ0HzpnVpE0/R3/C/wD6sSGB/myxPHrzWBmeSV1BiulABJeMgDqR8fLI+Nebm5rjesenh4ZlO1ei2etWdy4QMUY9N+Oass15XA7W8ngiupM4OWOQOff4/tXouiXLXOnxs5yw8JPrwP6EVeHluV1U5uGYzcT6KKK9DzlpAcjIopaBBRRS0ETUJobSBruWIOUxjAGSc4H3qJLe6dE0BMMZilVpVkWMEAYyTjr0FWuBSbV8wD8RQVv47S4isKCId448PdY8yATwPMYrkXmmd9LFNFHEUYp44xhv1A4x/sNWmxP5F5/0ik7tDnKKc89POgrBd6e8KNJbKImijY7oxhFKvtBHpjcOM4yfenoH0yZkjgSAkghVEWOgBI6fCpvdpx4F4GBx5UCNFOVRQfUKKCBq9j+K01oYV5jwUVR6cYHyJrzm+tmEgH4fvGxhvHt6dPua9XxUS70yzu23TwgsepHGa8/Lw972n16OHm6TrfjzextiLhmWBkc4A/M3A5Az5+wr0fR7VrOwjicEP1Yen9jFLa6baWjBoYQGHRjyRUunFw9Lu/Tl5u81Pgooor0POKWkooAEHofasdedobW67Q6VPY3eYbe21FrmNnK7DHsX8xRyMEHHB9utbGmltbdJZZUt4lklGJHCAF/ifOgxkXbDUTbXYaC0e6ilsVjbayIy3L7RkbieMZycE+gqVZ9pNVW/giv7exMDahNYN+H37y8cbSbwDxg7cbeT55rSxadYwpsisrZFJU7ViUDKnIPTyPIrsWlsHDi3hDCQyg7BkORgt8SCRmgyGm9sNSvNPa6GmxMJbIXVuFkxgllGxsnxfq6jAJBHBxU+7127fsTf6tbd0LyCOUZjRiEZGIyUYAggclfXzNXS6RpiLcKun2oW5/zwIV/N/wB3HNP21tBaQJb2sEcMK52xxoAo+VBlzHbaeqvado7q4luLKd+5mn738SRHnvB/IR1yMDnGKi2Xaq8gtbG1isnuzBYWctzI5be/ejyIBGRgnxEZPFam00XSrJpms9OtYGnBWUxwqpcHqDiiXRdLlktpJdOtXe1ULAWiB7sDoB6Y8vSgpl7UyHXDZG2he2Z7iKOaN3J3QruIYlQvkQQCcHrVl2Y1K71jRrbUb21itjcxrLFHHMZPAyggnIGDyeOeMU+ujaYt292thbi5csWlEY3EsMMc+4JzUq3gitYI4LaNYoYkCRogwFUDAAHpQOUUUUBRRRQFFFFAUUUUBRRRQFFFFAUUUUBRRRQFFFFAUUUUH//Z";
		PrintWriter pw = response.getWriter();
		pw.print(
			"<div style='text-align: center;'>"+
	            "<h1><b>e-BookShop</b></h1>"+
	            "<h3>Online Store</h3>"+
	        "</div>"+
	        "<div style='text-align: right; padding-right: 15%;'>"+
	            "<form action='HelloServlet' method='post'>"+
	                "<div style='display: inline-flex;flex-direction: row;'>"+
	                    "<div>"+
	                        "<input type='text' name='author' style='height: 34px;width: 200px;border-radius: 10px 0px 0px 10px;'>"+
	                    "</div><div>"+
	                        "<button type='submit'"+
	                        "style='height: 40px;width: 50px;border-radius: 0px 10px 10px 0px;background-color: white;'>"+
	                            "<img height='35px' src='https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Search_Icon.svg/1024px-Search_Icon.svg.png'>"+
	                        "</button></div></div></form></div>"+
	        "<div style='width:100%;margin-top: 50px;'>"+
	            "<table border='2px solid black' align='center'>"
				);
		String authorName = request.getParameter("author");
		
		String url = "jdbc:mysql://localhost:3306/wtl05";
		String uname = "root";
		String password = "Dh@050701$";
		
		try {
			Connection connection = DriverManager.getConnection(url, uname, password);
			Statement statement = connection.createStatement();
			ResultSet responseData;
			if(authorName=="") {
				responseData = statement.executeQuery("SELECT * FROM books");
			}else {
				responseData = statement.executeQuery("SELECT * FROM books where book_author='"+authorName+"'");
			}
			String title, author;
			int price, qty, bid;
			while(responseData.next()) {
				bid=responseData.getInt("book_id");
				title = responseData.getString("book_title");
				author = responseData.getString("book_author");
				price = responseData.getInt("book_price");
				qty = responseData.getInt("qty");
				pw.print(
						"<tr><td><img src="+img_url+"></td>"+
							  "<td style=\"padding: 0 20px 0 20px;\">\r\n"
		+ "                        <div style=\"font-size: 24px;\">"+title+"</div>\r\n"
		+ "                        <div style=\"font-size: 16px; color:grey\">#"+bid+"</div>\r\n"
		+ "                    </td>\r\n"
		+ "                    <td style=\"padding: 0 20px 0 20px;\">\r\n"
		+ "                        <div style=\"font-size: 21px;\">"+author+"</div>\r\n"
		+ "                    </td>\r\n"
		+ "                    <td style=\"padding: 0 20px 0 20px;\">\r\n"
		+ "                        <div style=\"font-size: 20px;\">Qty:<br><br>"+qty+"</div>\r\n"
		+ "                    </td>\r\n"
		+ "                    <td style=\"padding: 0 20px 0 20px;\">\r\n"
		+ "                        <div style=\"\r\n"
		+ "                            font-size: 24px; \r\n"
		+ "                            color: rgb(236, 55, 115); \r\n"
		+ "                            transform: rotate(-15deg);\r\n"
		+ "                            \">$"+price+"</div>\r\n"
		+ "                    </td>\r\n"
		+ "                </tr>"
						);
			}
			pw.print("</table></div>");
			pw.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
