namespace TestProject1
{
    public class IsAdultTest
    {

        //Mock function - for testing

        public bool IsAdult(int age) { return age >= 18; }

        //Unit test
        [Test]
        public void Test1()
        {
            Assert.That(IsAdult(17), Is.EqualTo(false));
        }


        [Test]
        public void Test2()
        {
            Assert.That(IsAdult(18), Is.EqualTo(true));
        }

        [Test]
        public void Test3()
        {
            Assert.That(IsAdult(29), Is.EqualTo(true));
        }
    }
}
