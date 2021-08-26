<template>
  <body id="login-page">
    <el-form class="login-container" label-position="left" label-width="10px">
      <h3 class="login_title">系统登录</h3>
      <el-form-item>
        <el-input
          type="text"
          v-model="loginForm.loginName"
          auto-complete="off"
          placeholder="账号"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="密码"
        ></el-input>
      </el-form-item>
      <el-form-item style="width: 100%">
        <el-button
          type="primary"
          style="width: 100%;  border: none"
          @click="login"
          >登录</el-button
        >
      </el-form-item>
    </el-form>
  </body>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        loginName: '',
        password: ''
      },
      responseResult: []
    }
  },

  methods: {
    login () {
      this.$axios
        .post('/login', {
          loginName: this.loginForm.loginName,
          passWord: this.loginForm.password
        })
        .then(Resp => {
        //   console.log(Resp)
        //   this.$router.replace({path: '/hello'})

          if (Resp.data.code === 200) {
            this.$router.replace({path: '/hello'})
          } else {
            this.$alert(Resp.data.message, '提示', {
              confirmButtonText: '确定'
            })
          }
        })
        .catch(failReso => {
        })
    }
  }
}
</script>

<style scoped>
#login-page {
  background: url("../assets/img/bg.jpg") no-repeat;
  background-position: fixed;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}
body {
  margin: 0px;
}
.login-container {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 200px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}

.login_title {
  margin: 0px auto 40px auto;
  text-align: center;
  color: #505458;
}
</style>
