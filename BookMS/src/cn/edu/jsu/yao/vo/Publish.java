package cn.edu.jsu.yao.vo;
import java.io.Serializable;
/**
 * ������
 * @author ������
 *
 */
public class Publish implements Serializable{
	private String publisId;//������ı��
	private String publisName;//�����������
	private String leader;//�����紴ʼ��
	private String sex;//�����˵��Ա�
	public Publish() {
		super();
	}
	
	public Publish(String publisId, String publisName, String leader, String sex) {
		super();
		this.publisId = publisId;
		this.publisName = publisName;
		this.leader = leader;
		this.sex = sex;
	}
	public String getPublisId() {
		return publisId;
	}
	public void setPublisId(String publisId) {
		this.publisId = publisId;
	}
	public String getPublisName() {
		return publisName;
	}
	public void setPublisName(String publisName) {
		this.publisName = publisName;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Publish [publisId=" + publisId + ", publisName=" + publisName + ", leader=" + leader + ", sex=" + sex
				+ "]";
	}
}
