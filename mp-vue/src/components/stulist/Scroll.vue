<template>
  <div class="infinite-list-wrapper" style="overflow:auto">
    <ul
      class="list"
      v-infinite-scroll="load"
      infinite-scroll-disabled="disabled">
      <div v-for="i in count" class="list-item">
        <el-container type="flex">
          <el-aside width="200px"><Headimg/></el-aside>
          <el-main>
            <el-row type="flex" justify="start">username:{{i}}</el-row>
            <el-row type="flex" justify="start">
              <Stutags/>
            </el-row>
          </el-main>
          
        </el-container>
      </div>
    </ul>
    <p v-if="loading">加载中...</p>
    <p v-if="noMore">没有更多了</p>
  </div>
</template>

<script>
  import Headimg from '@/components/stulist/Headimg'
  import Stutags from '@/components/stulist/Stutags'
  export default {
    name:'Scroll',
    data () {
      return {
        count: 50,
        loading: false
      }
    },
    computed: {
      noMore () {
        return this.count >= 200
      },
      disabled () {
        return this.loading || this.noMore
      }
    },
    components:{
      Headimg,
      Stutags,
    },
    methods: {
      load () {
        this.loading = true
        setTimeout(() => {
          this.count += 2
          this.loading = false
        }, 2000)
      }
    }
  }
</script>