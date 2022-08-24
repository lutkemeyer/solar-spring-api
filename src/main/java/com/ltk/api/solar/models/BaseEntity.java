package com.ltk.api.solar.models;

import com.ltk.api.solar.models.generators.UuidGenerator;
import com.ltk.api.solar.tools.util.LocalDateTimeUtil;
import com.ltk.api.solar.tools.Uuid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class BaseEntity {
	
	@Id
	@EqualsAndHashCode.Include
	@GenericGenerator(name = "string_based_custom_sequence",
	                  strategy = UuidGenerator.STRATEGY_PATH)
	@GeneratedValue(generator = "string_based_custom_sequence")
	@Column(name = "ID",
	        length = 32)
	private String id;
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "TIMECREATED",
	        updatable = false)
	private LocalDateTime timeCreated;
	
	@ManyToOne(fetch = FetchType.LAZY,
	           cascade = CascadeType.ALL)
	@JoinColumn(name = "IDUSERCREATED",
	            updatable = false)
	private User userCreated;
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "TIMECHANGED")
	private LocalDateTime timeChanged;
	
	@ManyToOne(fetch = FetchType.LAZY,
	           cascade = CascadeType.ALL)
	@JoinColumn(name = "IDUSERCHANGED")
	private User userChanged;
	
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "TIMEREMOVED")
	private LocalDateTime timeRemoved;
	
	@ManyToOne(fetch = FetchType.LAZY,
	           cascade = CascadeType.ALL)
	@JoinColumn(name = "IDUSERREMOVED")
	private User userRemoved;
	
	public void setUserCreated(User userCreated) {
		this.userCreated = userCreated;
		this.timeCreated = LocalDateTimeUtil.now();
	}
	
	public void setUserChanged(User userChanged) {
		this.userChanged = userChanged;
		this.timeChanged = LocalDateTimeUtil.now();
	}
	
	public void setUserRemoved(User userRemoved) {
		this.userRemoved = userRemoved;
		this.timeRemoved = LocalDateTimeUtil.now();
	}
	
	public boolean isActive() {
		return getTimeRemoved() != null;
	}
	
	public boolean isNotActive() {
		return !isActive();
	}
	
	public boolean isNew() {
		String id = getId();
		return id == null || Uuid.isTemporary(id);
	}
	
	public boolean hasTempId() {
		return id != null && Uuid.isTemporary(id);
	}
	
	public boolean hasNotTempId() {
		return id != null && !Uuid.isTemporary(id);
	}
	
	public boolean isNotNew() {
		return !isNew();
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ": id=\"" + getId() + "\"";
	}
	
}
