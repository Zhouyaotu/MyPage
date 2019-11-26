<template>
  <div>
    <el-container>
      <el-header>
        <div>个人卡片</div>
      </el-header>
      <el-main>
        <el-col :gutter="10">
          <el-tabs type="border-card" stretch="true">
            <el-tab-pane label="信息管理">
              <el-row>
                <div class="grid-content bg-purple">
                  <el-row>
                    <el-col width="200px" :span="3">
                      <el-row style="margin:50px 50px 10px 20px">
                        <Headimg v-bind:head="this.info.detail.headImg" />
                      </el-row>
                      <el-row style="margin:-135px 50px -40px 30px ;font-size:25px">
                        <i class="el-icon-setting"></i>
                      </el-row>
                    </el-col>
                    <el-col :span="13" style="margin-left:-250px ; margin-top:-25px; margin-bottom:65px;">
                      <div style="margin:0px 50px -40px 30px ;font-size:30px">{{info.base.username}}</div>
                      <div style="margin:-120px 50px -120px 30px ">
                        <Tags />
                      </div>
                      <div style="margin:0px 50px -100px 30px ;font-size:20px">
                        性别：{{info.detail.sex}}
                        <span></span>
                        专业：{{info.detail.major}}
                      </div>
                      <div style="margin:-50px 50px -40px 30px ;font-size:20px">
                        现居：{{info.detail.liveCity}}
                        <span></span>
                        家乡：{{info.detail.homeCity}}
                      </div>
                    </el-col>
                    <el-col :span="8" >
                      <el-container >
                        <el-header>
                          <div style="margin-left:-400px ; font-size: 20px;">
                            <i class="el-icon-delete"></i>
                            <i class="el-icon-setting"></i>
                            <i class="el-icon-share"></i>
                          </div>
                        </el-header>
                        <el-main style="background-color: #ffffff; ">还没有自我介绍哦</el-main>
                      </el-container>
                    </el-col>
                  </el-row>
                </div>
              </el-row>
            </el-tab-pane>
            <el-tab-pane label="我的动态">动态</el-tab-pane>
            <el-tab-pane label="我关注的">我关注的</el-tab-pane>
            <el-tab-pane label="谁关注我">谁关注我</el-tab-pane>
          </el-tabs>
        </el-col>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import Headimg from "@/components/common/Headimg";
import Tags from "@/components/common/Stutags";
export default {
  name: "AppIndex",
  data() {
    return {
      info: {}
    };
  },
  components: {
    Headimg,
    Tags
  },
  created: function() {
    this.getInfo();
  },
  methods: {
    getInfo() {
      this.$axios
        .get(
          "/user/get-user-info",
          { params: { id: this.$store.state.user.uid } },
          { emulateJSON: true }
        )
        .then(resp => {
          if (resp && resp.data.code === 0 && resp.status === 200) {
            this.info = resp.data.attribute;
          } else {
            alert(status.data.description);
          }
          this.info.detail.headImg =
            this.$axios.defaults.hostport + this.info.detail.headImg;
          //alert(this.info.detail.headImg);
        });
    }
  }
};
</script>

<style scoped>
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}

.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #eceff3;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>

