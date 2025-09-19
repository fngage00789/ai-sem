package th.co.ais.domain.common;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import th.co.ais.domain.annotation.Convenience;


public abstract class BaseDomain implements Serializable {

	private static final long serialVersionUID = -6265520847681224672L;

	protected String refId;
	protected int dbVersion;
	protected String modifiedBy;

	protected Calendar createdDate;
	protected Calendar modifiedDate;
	protected Calendar cancelledDate;

	protected transient boolean isSnapshot = false;
	protected transient Number snapshotVersion;

	public Number getSnapshotVersion() {
		return snapshotVersion;
	}

	public void setSnapshotVersion(Number snapshotVersion) {
		this.snapshotVersion = snapshotVersion;
	}

	public boolean isSnapshot() {
		return isSnapshot;
	}

	public void setSnapshot(boolean isSnapshot) {
		this.isSnapshot = isSnapshot;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public int getDbVersion() {
		return dbVersion;
	}

	public void setDbVersion(int dbVersion) {
		this.dbVersion = dbVersion;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Calendar getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(Calendar cancelledDate) {
		this.cancelledDate = cancelledDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	@Override
	public boolean equals(Object obj) {
		return CommonUtils.isEqualById(this, obj);
	}

	public int compareTo(BaseDomain baseDomain) {
		return CommonUtils.compareObjById(this, baseDomain);
	}

	@Override
	public int hashCode() {		
		return System.identityHashCode(this);
	}

	/**
	 * @return all dependency objects.
	 */
	@Convenience
	public Set<BaseDomain> getDependencies() {
		return new HashSet<BaseDomain>();
	}

}
