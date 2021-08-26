<template>
    <div>
        <el-dialog
                v-bind="$attrs"
                v-on="$listeners"
                @open="onOpen"
                @close="onClose"
                :close-on-click-modal='true'
                :append-to-body='true'
                title='上传文件'
                width='400px'
                center>
            <el-row :gutter="15">
                <el-upload
                  class="upload"
                  drag
                  action="https://jsonplacehoder.typeicon.com/posts/"
                  :file-list="fileList"
                  :on-success="handlesuccess"
                  :on-error="handleError"
                  :before-upload="upload_file"
                  >
                  <i class="el-icon-upload"></i>
                  <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                </el-upload>
            </el-row>
        </el-dialog>
    </div>
</template>

<script>
export default {
  data () {
    return {
      fileList: []
    }
  },
  methods: {
    onOpen () {
      console.log('dakai')
    },
    onClose () {
      console.log('guanbi')
      this.$emit('update:visible', false)
    },
    upload_file (file) {
      var formData = new FormData()
      formData.append('filename', file)
      let config = {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      }
      this.$axios
        .post('/upload', formData, config)
        .then(Resp => {
          console.log(Resp)
          this.$router.push({name: 'content', params: {mlist: Resp.data.data}})
        })
        .catch(failReso => {
        })
    },
    handlesuccess (response, file, fileList) {
      console.log(response)
      console.log(file)
      console.log(fileList)

      this.$emit('update:visible', false)
    },
    handleError (err, file, fileList) {
      console.log(err)
      console.log(file)
      console.log(fileList)

      this.$emit('update:visible', false)
    }
  }
}
</script>

<style>

</style>
