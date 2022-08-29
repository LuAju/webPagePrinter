<template>
  <div>
    <div style="margin-bottom: 10px">
      <button @click="print">点击拥有新垣结衣</button>
    </div>
    <img
      ref="img1"
      src="https://img2.baidu.com/it/u=4118395744,2724693854&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1661878800&t=3eb560434af8bfd49634f804991762ee"
    />
  </div>
</template>

<script>
import html2canvas from "html2canvas";
export default {
  data() {
    return {};
  },
  mounted() {
    this.$axios
      .get(
        "/sayHello" //请求url
      )
      // 网络请求成功
      .then((res) => {
        console.log("成功", res.data);
        // 更新分页信息
      })
      // 网络请求失败
      .catch((err) => {
        console.log("失败", err);
        alert(err.response.data.msg);
      });
  },
  methods: {
    print() {
      let that = this;

      html2canvas(this.$refs.img1, {
        // 添加这个即可，允许跨域
        useCORS: true,
      }).then((canvas) => {
        console.log(canvas.toDataURL("image/png"));
        let param = { base64str: canvas.toDataURL("image/png") };
        that.$axios
          .post(
            "/Base64Toimg2", //请求url
            param
          )
          // 网络请求成功
          .then((res) => {
            console.log("成功", res.data);
          })
          // 网络请求失败
          .catch((err) => {
            console.log("失败", err);
          });
      });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
