<template>
  <el-container class="outer">
    <el-header>
      <el-row type="flex" justify="end">
        <el-button-group>
          <el-button type="primary" icon="el-icon-upload" @click="centerDialogVisible = true">上传</el-button>
        </el-button-group>
      </el-row>
    </el-header>
    <el-main>
      <el-row type="flex" justify="center" align="middle">
        <el-col :span="15">
          <el-input type="Text" v-model="searchtext" auto-complete="off" placeholder="搜索">
            <el-button type="primary" slot="append" icon="el-icon-search" @click="submitForm('searchForm')">搜索</el-button>
          </el-input>
        </el-col>
      </el-row>
    </el-main>
    <Upload :visible.sync="centerDialogVisible"></Upload>
  </el-container>
</template>

<script>
import Upload from './Upload'
export default {
  data () {
    return {
      searchtext: '',
      fileList: [],
      centerDialogVisible: false
    }
  },
  components: {
    Upload
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>

<style scoped>
  .el-main {
    height: 100%;
  }
  .el-row {
    height: 100%;
  }
  .outer{
    height: 100%;
    width: 100%;
  }
  .el-input--medium .el-input__inner {
      height: 150px;
      line-height: 150px;
  }
</style>
