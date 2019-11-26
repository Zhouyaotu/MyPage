<template>
  <div>
    <el-container>
      <el-header>
        <div>个人卡片</div>
      </el-header>
      <el-main>
        <el-col :gutter="10">
          <el-tabs type="border-card" stretch=true>
            <el-tab-pane label="信息管理">
              <el-row>
                <div class="grid-content bg-purple">
                  <el-container>
                    <el-aside width="200px">
                      <div style = "margin-top:50px"><Headimg/></div>
                      
                    </el-aside>
                    <el-main>Main</el-main>
                  </el-container>
                </div>
              </el-row>
              <el-row>
                <div class="grid-content bg-purple"></div>
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

export default {
  name: "AppIndex",
  data() {
    return {
      info: []
    };
  },
  components: {
    Headimg
  },
  method: {}
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

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
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

.el-row {
  margin-bottom: 10px;
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

