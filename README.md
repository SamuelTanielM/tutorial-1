<a name="readme-top"></a>

<br />
<div align="center">
  <a href="https://github.com/SamuelTanielM/eshop">
    <img src="pictures/logo_hae.png" alt="To Source Code" width="80" height="80">
  </a>

<h3 align="center">Tutorial Modul</h3>

  <p align="center">
    Website
    <br />
    <a href="https://github.com/SamuelTanielM/eshop"><strong>Explore the code »</strong></a>
    <br />
    <br />
    <a href="https://eshop-samuelt-adpro.koyeb.app">View Site</a>
    ·
    <a href="https://scele.cs.ui.ac.id/course/view.php?id=3747">View Assignment</a>
  </p>
</div>


🏪 Tutorial Modul untuk Advance Programming Genap 2023/2024✨
<details>
  <summary>Daftar Tugas</summary>
  <ol>
      
<hr>
      <details>
      <summary><a href="#tugas-2">Tutorial / Module 1 | ⭐ Coding Standards</a></summary>

<hr>
<hr>
<!-- #TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>: TABLE OF CONTENTS -->
<h3 align="center">Tutorial / Module 1 | ⭐ Coding Standards</h3>   

<a name="tugas-9"></a>
<details>
<summary>Table of Contents</summary>
<ol>
  <li>
    <a href="#reflection-1-1">Reflection 1</a>
  </li>
  <li>
    <a href="#reflection-1-2">Reflection 2</a>
  </li>

</ol>
</details>



<!-- ABOUT THE PROJECT -->
<a name="reflection-1-1"></a>
## Reflection 1

You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code. Please write your reflection inside the repository's README.md file.

(mohon maaf kalau Inggris saya jelek) I've learned that the module for this project provides a good basis for coding practices and clean code principles. Following the module and its style of coding, I've improved in noticing and connecting the relationship between files. Albeit, I still found it pretty inconvenient to create many files and track or change them when there's a problem occurred. Not only that, the IDE is new to me, and it's challenging to get used to since it doesn't have a good display, missing shortcuts, and lag. So I have to just get used to it first, then realize it provides much more than VS Code, it tells where the problems are in different files easily. 

Since clean code principles are somewhat dependent on a programmer's preference, I don't think it matches my way of reading the lines from the code. I usually use a highlight extension in VSCode, which highlights the comments and important codes to easily help me read it, making it easy to create long lines of code without getting confused, but since this is a learning opportunity, I'll try my best to suit myself coding using the principles.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- ABOUT THE PROJECT -->
<a name="reflection-1-2"></a>
## Reflection 2

1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors? 

I think the tests are more required in more complex projects. The tests in my program don't differ from testing it manually rendering it useless and less efficient, but I can see that once the project gets more complex, the tests will be very helpful. 

To make sure that the unit tests are enough to verify the program is by trying out many different situations that the program is not intended to, therefore, you can easily find bugs and errors. It doesn't mean that code has no bugs or errors if it has 100% code coverage, there are many ways to break the code from what the code can handle. Although, if it's a simple project, maybe it could have no bugs or errors, but there may be errors or bugs that haven't been found or known to cause yet.

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables. What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner! Please write your reflection inside the repository's README.md file.

I think it will clutter the test files too much, if you need to create a new file only for several items especially if you keep track of the number of items, creating the program in the same file can be better. For example, after creating the product, add another test if the number of items is increased or not and verify it. Creating the same setup procedures and instance variables for every test in the future could potentially slow down the time it took to test the project. 

The cleanliness of the code will probably look good, but navigating the projects with other codes will be hard. The new code wouldn't reduce the code quality, since it has the same setup, perhaps if the setup before is already bad, then it will be bad, but if it's good, then probably not. If we're talking about the test file quality then probably yes, but ultimately not, since it can provide for future tests that can be created or occur with relatable problems. The potential clean code issues are the new functional test is not as good as the prior, it doesn't provide readability of the code, efficiency while maintaining trackability, and many more. 

The possible improvements are as such:
- make sure the code is readable for everyone, especially on the team
- it is trackable for any potential problems that may occur
- efficient with the code
- if the test can be run in the same file as another test and can cut down the time, then it's probably better to create it in the same file


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>


</details>

<hr>
      <details>
      <summary><a href="#tugas-2">Tutorial / Module 2 | ⭐ CI/CD</a></summary>

<hr>
<hr>
<!-- #TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>: TABLE OF CONTENTS -->
<h3 align="center">Refleksi Module 2 | ⭐ CI/CD</h3>   

<a name="tugas-9"></a>
<details>
<summary>Table of Contents</summary>
<ol>
  <li>
    <a href="#code-quality">Code quality issue(s)</a>
  </li>
  <li>
    <a href="#ci-cd">Met the definition of Continuous Integration and Continuous Deployment</a>
  </li>
  <li>
    <a href="#bonus">Met the definition of Continuous Integration and Continuous Deployment</a>
  </li>

</ol>
</details>



<!-- ABOUT THE PROJECT -->
<a name="code-quality"></a>
## Code quality issue(s)

List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them!

- Unused import 'org.springframework.boot.test.mock.mockito.MockBean'


  ada banyak dalam file yang mengimport library dan tidak digunakan, solusinya saya kunjungi setiap file dan menghilangan setiap library yang tidak digunakan sehingga ketika dimerge ke main sudah hilang masalah tersebut, dengan demikian unused import tersebut mengurangi beban import library pada setiap kode

- Document empty method body

  terdapat method yang tidak ada penjelasan saya tambahkan comment untuk menjelaskan fungsinya sehingga menghindari fungsi yang tidak memiliki penjelasan dan kedepannya dapat digunakan oleh pengguna lain dengan mudah dan dapat dimengerti

- Position literals first in String comparisons

  mengerti apa maksudnya dan tujuannya untuk menghindari nullpointerexception, dan mengganti setiap masalah tersebut 
dari
if (columns.size() > 0 && columns.get(0).getText().equals("Product Name"))

  menjadi

  if (columns.size() > 0 && "Product Name".equals(columns.get(0).getText()))

- Unnecessary modifier 'public' on method 'delete': the method is declared in an interface type

  dengan menghilangkan segala public pada tiap method create, findall, delete, findbyid, dan update, sehingga lebih baik kodenya

- The JUnit 5 test method name 'delete_ShouldReturnDeletedProduct' doesn't match '[a-z][a-zA-Z0-9]*'

  dengan mengganti semua yang tidak camel case mengikuti camel case

- Substitute calls to size() == 0 (or size() != 0, size() > 0, size() < 1) with calls to isEmpty()
  
  mengganti size > 0 dengan !empty

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<a name="ci-cd"></a>
## Met the definition of Continuous Integration and Continuous Deployment

Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!

Workflows CI/CD yang digunakan pada kode saya yaitu PMD (Project Mess Detector) untuk menganalisis basis kode untuk potensi masalah dan mematuhi code conventions, supaya kodenya saya efektif dalam hal maintainabilitas dan kejelasan.

Selain itu, dengan mengikuti modul saya telah menerapkan Scorecard supply chain analysis tool untuk mengevaluasi dan mengoptimalkan proses proses supply chain, sehingga dari data yang terkumpul saya bisa meningkatkan efisiensi dan mengurangi cost.

Dalam bagian CD, saya juga telah mendeploy aplikasi saya di Koyeb, yang memungkinkan skalabilitas dan ketersediaan yang lancar. CI/CD ini dikonfigurasi untuk memantau cabang master, secara otomatis memicu build, testing, dan juga deployment ketika ada perubahan kode. Sehingga kode sudah aman dan dideploy dengan mulus. [Link Deployment](https://eshop-samuelt-adpro.koyeb.app)

Dengan demikian, implementasi CI/CD saya, dikombinasikan dengan alat-alat seperti PMD, Scorecard, dan deployment di Koyeb, memungkinkan saya untuk mempertahankan tingkat kualitas kode yang tinggi, mengoptimalkan proses supply chain, dan menghasilkan aplikasi yang terus menerus bagus kedepannya.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<a name="bonus"></a>
## Bonus

Code coverage saya gunakan https://github.com/marketplace/actions/jacoco-reporter

dan dapat dicek pada [Github Action](https://github.com/SamuelTanielM/tutorial-1/actions/runs/7900930327/job/21563618793) 

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>


</details>

<hr>
      <details>
      <summary><a href="#tugas-2">Tutorial / Module 3 | ⭐ OO Principles & Software Maintainability</a></summary>

<hr>
<hr>
<!-- #TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>: TABLE OF CONTENTS -->
<h3 align="center">Reflection ⭐ OO Principles & Software Maintainability</h3>   

<a name="tugas-9"></a>
<details>
<summary>Table of Contents</summary>
<ol>
  <li>
    <a href="#principles">Principles applied to project</a>
  </li>
  <li>
    <a href="#benefits">Benefits of applying SOLID principles and example</a>
  </li>
  <li>
    <a href="#disadvantages">Disadvantages if you do not apply SOLID principles to your project and example</a>
  </li>

</ol>
</details>



<!-- ABOUT THE PROJECT -->
<a name="principles"></a>
## Principles applied to project

- Separation of Concerns:

  memisahkan kelas-kelas Car dan Product ke dalam file-file terpisah, membantu pemeliharaan dan kejelasan dengan memfokuskan pada fungsionalitas tertentu di setiap file.

- Interface Segregation Principle (ISP): 

  implementasikan interface CarRepository dan ProductRepository, untuk bergantung hanya pada metode-metode yang digunakan, supaya fleksibilitas dan skalabilitas.

- Single Responsibility Principle (SRP): 

  setiap kelas dalam proyek memiliki satu tanggung jawab saja, seperti operasi akses data untuk repository dan definisi model untuk kelas-kelas Car dan Product.

- Open/Closed Principle (OCP): 

  mengkode ke interface (CarRepository dan ProductRepository), proyek terbuka untuk perluasan melalui penambahan implementasi baru sementara tertutup untuk modifikasi pada kode yang sudah ada.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- ABOUT THE PROJECT -->
<a name="benefits"></a>
## Benefits of applying SOLID principles and example

- Pemeliharaan: 

  SRP seperti pada nomor sebelumnya membuat lebih mudah memahami, memperbarui, dan memelihara program. Sehingga pas kita mau buat fitur baru perlu ditambahkan ke CarRepository, kita dapat fokus hanya pada memodifikasi kelas tersebut tanpa memengaruhi bagian lain

- Fleksibilitas: 

  implementasi interface dan mematuhi ISP memungkinkan untuk pertukaran implementasi dengan mudah. Misalnya, jika mekanisme penyimpanan data untuk Car perlu diubah, hanya implementasi CarRepository yang perlu dimodifikasi, sementara bagian lain dari tidak terpengaruh.

- Testabilitas: 

  Mengiktui prinicple SRP dan pemisahan tanggung jawab, komponen-komponen individu dari sistem menjadi lebih mudah diuji. Misalnya, unit test dapat ditulis khusus untuk implementasi CarRepository atau ProductRepository tanpa perlu menguji seluruh sistem.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>

<!-- ABOUT THE PROJECT -->
<a name="disadvantages"></a>
## Disadvantages if you do not apply SOLID principles to your project and example

- Duplikasi Kode: 

  Jika kita tidak mengiktu principle SRP, program dapat menjadi bengkak dan berisi kode yang berlogika sama/duplikat. Misalnya, jika ada kode untuk ngakses data tapi tersebar di berbagai file lain daripada terpusat di repository, jadi redundant karena banyak serupa diulangi di banyak file lain.

- Keterikatan yang Ketat: 

  kalau tidak mengikuti OCP dan DIP dapat menyebabkan dependent yang ketat antara file-file yang berbeda dari sistem. Misalnya, jika kelas-kelas langsung bergantung pada implementasi konkret daripada abstraksi, membuat perubahan pada satu bagian dari sistem mungkin memerlukan modifikasi pada beberapa bagian lain, sehingga jadi sulit di maintain.

- Kesulitan dalam Skalabilitas: 

  tanpa mematuhi ISP, menambahkan fungsionalitas baru ke file-file yang sudah ada mungkin memerlukan modifikasi pada interface dan implementasinya, memengaruhi bagian lain dari sistem. Misalnya, jika sebuah kelas mengimplementasikan interface yang besar dengan banyak metode, menambahkan metode baru ke antarmuka tersebut mungkin memaksa semua kelas yang mengimplementasikannya untuk memberikan implementasi, bahkan jika mereka tidak membutuhkannya. Hal ini dapat menyebabkan perubahan kode yang tidak perlu dan potensi bug.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>


</details>

<hr>
      <details>
      <summary><a href="#tugas-2">Tutorial / Module ? | ⭐ ?</a></summary>

<hr>
<hr>
<!-- #TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>:TODO:>>>: TABLE OF CONTENTS -->
<h3 align="center">Tugas 9: Integrasi Layanan Web Django dengan Aplikasi Flutter</h3>   

<a name="tugas-9"></a>
<details>
<summary>Table of Contents</summary>
<ol>
  <li>
    <a href="#pengambilan-json">pengambilan data JSON tanpa membuat model terlebih dahulu</a>
  </li>
  <li>
    <a href="#cookie-request">fungsi dari CookieRequest dan mengapa instance CookieRequest perlu untuk dibagikan ke semua komponen di aplikasi Flutter</a>
  </li>
  <li>
    <a href="#mekanisme-fetch">mekanisme pengambilan data dari JSON hingga dapat ditampilkan pada Flutter</a>
  </li>
  <li>
    <a href="#mekanisme-auth">mekanisme autentikasi dari input data akun pada Flutter ke Django hingga selesainya proses autentikasi oleh Django dan tampilnya menu pada Flutter.</a>
  </li>
  <li>
    <a href="#widget-dipakai">widget yang kamu dipakai pada tugas ini</a>
  </li>

  <li>
    <a href="#checklist9">implementasi checklist</a>
  </li>

</ol>
</details>



<!-- ABOUT THE PROJECT -->
<a name="pengambilan-json"></a>
## pengambilan data JSON tanpa membuat model terlebih dahulu

bisa tetapi prosedur yang perlu dilakukan dalam memparsing

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<hr>


</details>

  </ol>
</details>
