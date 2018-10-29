//package com.gcbi.damo.rpt;
//
//import java.util.List;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.gcbi.damo.rpt.eo.HtmlStringEo;
////SimpleJpaRepository<T, ID>
//public interface HtmlStringRpt extends JpaRepository<HtmlStringEo, Long>,JpaSpecificationExecutor<HtmlStringEo> {
//	
//	@Query(value="SELECT  Distinct batch_id FROM `html_string`",nativeQuery=true)
//	public List<HtmlStringEo> findAllBatchId();
//	
//	//查出用户对应数据
//	@Query(value="SELECT * FROM `html_string` hs left  JOIN  annotation a ON ( hs.batch_id = a.batch_id and hs.user_id=a.user_id  "
//			+ "and hs.rel_id=a.rel_id)where hs.user_id=:userId	and a.label is not null and hs.batch_id=:batchId",nativeQuery=true)
//	public Page<HtmlStringEo> findByUserIdAndBatchId(Pageable pageable,@Param(value="userId") Long userId,@Param(value="batchId") Long batchId);
//	
//}
