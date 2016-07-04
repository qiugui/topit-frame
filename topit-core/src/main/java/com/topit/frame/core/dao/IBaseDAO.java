package com.topit.frame.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * @ClassName: IBaseDAO
 * @Description: jichuDAO接口
 * @author ivan.zhang
 * @date 2014年11月13日 下午2:31:55
 * 
 * @param <T>
 */
public abstract interface IBaseDAO<T> {

	/**
	 * @Title: save
	 * @Description: 保存对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public boolean save(T entity) throws Exception;

	/**
	 * @Title: delete
	 * @Description: 删除对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public boolean delete(T entity) throws Exception;

	/**
	 * @Title: update
	 * @Description:更新对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public boolean update(T entity) throws Exception;

	/**
	 * @Title: findById
	 * @Description: 根据主键ID查找对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T findById(Serializable id) throws Exception;

	/**
	 * @Title: load
	 * @Description: 根据主键ID加载对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T load(Serializable id) throws Exception;

	/**
	 * @Title: queryAll
	 * @Description: 全查询
	 * @return
	 * @throws Exception
	 */
	public List<T> queryAll() throws Exception;

	/**
	 * @Title: getCount
	 * @Description: 统计全表记录数
	 * @return
	 * @throws Exception
	 */
	public int getCount() throws Exception;

	/**
	 * @Title: save
	 * @Description: 批量保存对象
	 * @param entityList
	 * @return
	 * @throws Exception
	 */
	public boolean save(List<T> entityList) throws Exception;
	/**
	 * @Title: delete
	 * @Description: 删除对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean delete(Serializable id) throws Exception;
	/**   
	 * @Title: getListForPage   
	 * @Description: 分页查询指定页数   
	 * @param hql  查询hql语句
	 * @param offset   从第几条记录开始
	 * @param length    页面数据条数
	 * @return   分页数据     
	 */
	public List<T> getListForPage(DetachedCriteria criteria, int offset, int length)throws Exception;
	
	/**   
	 * @Title: getListForPage   
	 * @Description: 根据hql进行分页查询   
	 * @param hql    查询语句
	 * @param firstResult  查询起始索引
	 * @param pageSize		查询步长
	 * @return
	 * @throws Exception        
	 */
	 
	public List<?> getListForPage(String hql, int firstResult, int pageSize)throws Exception;
	
	/**   
	 * @Title: update   
	 * @Description:  根据hql语句和属性更新数据  
	 * @param hql
	 * @param params
	 * @return        
	 */
	public void excuteSQL(String sql);
	public boolean update(String hql,Object ...params )throws Exception;

}
