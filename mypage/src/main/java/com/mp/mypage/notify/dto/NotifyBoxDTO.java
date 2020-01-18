package com.mp.mypage.notify.dto;

import com.mp.mypage.notify.entity.NotifyAnnounce;
import com.mp.mypage.notify.entity.NotifyRemind;

import java.util.List;

public class NotifyBoxDTO {
    private Integer unreadTotal;
    private List<AnnounceDTO> reminds;
    private List<RemindDTO> announces;

    @Override
    public String toString() {
        return "NotifyBoxDTO{" +
                "unreadTotal=" + unreadTotal +
                ", reminds=" + reminds +
                ", announces=" + announces +
                '}';
    }

    public Integer getUnreadTotal() {
        return unreadTotal;
    }

    public NotifyBoxDTO setUnreadTotal(Integer unreadTotal) {
        this.unreadTotal = unreadTotal;
        return this;
    }

    public List<AnnounceDTO> getReminds() {
        return reminds;
    }

    public NotifyBoxDTO setReminds(List<AnnounceDTO> reminds) {
        this.reminds = reminds;
        return this;
    }

    public List<RemindDTO> getAnnounces() {
        return announces;
    }

    public NotifyBoxDTO setAnnounces(List<RemindDTO> announces) {
        this.announces = announces;
        return this;
    }
}
