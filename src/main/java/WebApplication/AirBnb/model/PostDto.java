package WebApplication.AirBnb.model;


import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import WebApplication.AirBnb.domain.Ratings;
import WebApplication.AirBnb.domain.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	private long postId;
	private long accountId;
	private long romTypeInfoId;
	private String userName;
	private String postDate;
	@NotBlank(message = "Bạn chưa nhập tiêu đề")
	private String title;
	@NotBlank(message = "Bạn chưa nhập nội dung tin")
	private String content;
	@NotBlank(message = "Bạn chưa nhập tên khách sạn!")
	private String hotelName;
	private int status;
	@NotNull(message = "Bạn chưa nhập giá!")
	private Double price;	
	private long locationId;
	private String locationName;
	@NotEmpty(message = "Bạn chưa nhập địa chỉ!")
	private String address;
	private double area;
	@NotNull(message = "Bạn chưa nhập số phòng!")
	private int roomAmount;
	private long roomTypeId;
	
	private String roomTypeName;
	private long bedTypeId;
	private String bedTypeName;
	private List<Long> lstServiceIds;	
	private List<String> lstServiceNames;
	private List<Services> lstServices;
	private List<Ratings> lstRatings;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String authorImage;
	private String authorPhoneNumber;
	private int ratingAmount;
	private double avarageStarNumber;
	public PostDto(long postId, long romTypeInfoId, String userName, String postDate,
			@NotBlank(message = "Bạn chưa nhập tiêu đề") String title,
			@NotBlank(message = "Bạn chưa nhập nội dung tin") String content,
			@NotBlank(message = "Bạn chưa nhập tên khách sạn!") String hotelName, int status,
			@NotNull(message = "Bạn chưa nhập giá!") Double price, String locationName,
			@NotEmpty(message = "Bạn chưa nhập địa chỉ!") String address, double area,
			@NotNull(message = "Bạn chưa nhập số phòng!") int roomAmount, String roomTypeName, String bedTypeName, String authorImage, String authorPhoneNumber) {
		super();
		this.postId = postId;
		this.romTypeInfoId = romTypeInfoId;
		this.userName = userName;
		this.postDate = postDate;
		this.title = title;
		this.content = content;
		this.hotelName = hotelName;
		this.status = status;
		this.price = price;
		this.locationName = locationName;
		this.address = address;
		this.area = area;
		this.roomAmount = roomAmount;
		this.roomTypeName = roomTypeName;
		this.bedTypeName = bedTypeName;
		this.authorImage = authorImage;
		this.authorPhoneNumber = authorPhoneNumber;
	}
	
	
	
	
	
}
