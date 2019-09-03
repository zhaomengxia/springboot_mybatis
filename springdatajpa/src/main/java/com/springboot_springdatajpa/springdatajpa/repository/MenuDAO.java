package com.springboot_springdatajpa.springdatajpa.repository;

import com.springboot_springdatajpa.springdatajpa.model.MenuModel;
import com.springboot_springdatajpa.springdatajpa.model.RoleModel;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @Author zhaomengxia
 * @create 2019/9/3 10:30
 */
@Repository
public class MenuDAO {
    @Autowired
    EntityManager entityManager;

    public List<MenuModel>  findByUserId(Long userId){

        String sql="SELECT " +
                "m.menu_id menuId ," +
                "m.permission permission ," +
                "m.url url " +
                "FROM" +
                "`user` u " +
                "LEFT JOIN user_role ur ON u.user_id = ur.user_id " +
                "LEFT JOIN role_menu rm ON ur.role_id = rm.role_id " +
                "LEFT JOIN menu m ON rm.menu_id = m.menu_id " +
                "WHERE 1=1 ";

        if (null!=userId){
            sql+=" AND u.user_id =:userId ";
        }
        Query query=entityManager.createNativeQuery(sql);

        if (null!=userId){
            query.setParameter("userId",userId);
        }

        query.unwrap(SQLQuery.class)
                .addScalar("menuId", StandardBasicTypes.LONG)
                .addScalar("permission",StandardBasicTypes.STRING)
                .addScalar("url",StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(MenuModel.class));

        return query.getResultList();
    }



    public List<RoleModel> findByUserID(Long userId){
        String sql="SELECT " +
                " r.role_id roleId, " +
                " r.role_name roleName " +
                " FROM " +
                " user_role ur " +
                " LEFT JOIN role r ON ur.role_id = r.role_id " +
                " WHERE 1=1 " ;


        if (null!=userId){
            sql+=" and ur.user_id=:userId ";
        }
        Query query=entityManager.createNativeQuery(sql);

        if (null!=userId){
            query.setParameter("userId",userId);
        }

        query.unwrap(SQLQuery.class)
                .addScalar("roleId",StandardBasicTypes.LONG)
                .addScalar("roleName",StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(RoleModel.class));
        return query.getResultList();
    }

}
