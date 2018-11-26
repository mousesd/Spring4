package net.homenet.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import java.util.List;

public class SampleJdbcDaoImpl extends JdbcDaoImpl {
    @Override
    protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[]{ username }
            , (resultSet, i) -> {
                SampleUser user = new SampleUser(resultSet.getString("login_id")
                    , resultSet.getString("password")
                    , AuthorityUtils.NO_AUTHORITIES);

                user.setFullName(resultSet.getString("full_name"));
                user.setDeptName(resultSet.getString("dept_name"));
                return user;
            });
    }

    @Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery
        , List<GrantedAuthority> combinedAuthorities) {

        SampleUser user = (SampleUser) userFromUserQuery;
        SampleUser newUser = new SampleUser(user.getUsername(), user.getPassword(), combinedAuthorities);
        newUser.setFullName(user.getFullName());
        newUser.setDeptName(user.getDeptName());
        return newUser;
    }
}
