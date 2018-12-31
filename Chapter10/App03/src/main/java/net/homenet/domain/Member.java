package net.homenet.domain;

@SuppressWarnings("unused")
public class Member {
    private Integer memberId;
    private String name;

    public Member() { }

    public Member(Integer memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Member{" +
            "memberId=" + memberId +
            ", name='" + name + '\'' +
            '}';
    }
}
