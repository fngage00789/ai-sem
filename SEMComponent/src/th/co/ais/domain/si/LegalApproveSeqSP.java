package th.co.ais.domain.si;

import java.util.Date;

import th.co.ais.domain.AbstractDomain;

public class LegalApproveSeqSP extends AbstractDomain{
	
		private String maxSq;
		private String siteApproveId;

		public void setMaxSq(String maxSq) {
			this.maxSq = maxSq;
		}

		public String getMaxSq() {
			return maxSq;
		}

		public void setSiteApproveId(String siteApproveId) {
			this.siteApproveId = siteApproveId;
		}

		public String getSiteApproveId() {
			return siteApproveId;
		}
		@Override
		public String getCreateBy() {
			return this.createBy;
		}
		@Override
		public Date getCreateDt() {
			return this.createDt;
		}
		@Override
		public String getUpdateBy() {
			return this.updateBy;
		}
		@Override
		public Date getUpdateDt() {
			return this.updateDt;
		}
		@Override
		public void setCreateBy(String createBy) {
			this.createBy = createBy;
		}
		@Override
		public void setCreateDt(Date createDt) {
			this.createDt = createDt;
		}
		@Override
		public void setUpdateBy(String updateBy) {
			this.updateBy = updateBy;
		}
		@Override
		public void setUpdateDt(Date updateDt) {
			this.updateDt = updateDt;
		}
		
		
}
