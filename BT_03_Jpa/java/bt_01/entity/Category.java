package bt_01.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private int categoryId;

	@Column(name = "categoryname", length = 255)
	private String categoryname;

	@Column(name = "images", length = 500)
	private String images;

	@Column(name = "status")
	private int status;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Video> videos;

	public Category() {}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public Video addVideo(Video video) {
		this.videos.add(video);
		video.setCategory(this);
		return video;
	}

	public Video removeVideo(Video video) {
		this.videos.remove(video);
		video.setCategory(null);
		return video;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryname=" + categoryname + ", images=" + images
				+ ", status=" + status + ", videos=" + videos + "]";
	}
	
	
}
