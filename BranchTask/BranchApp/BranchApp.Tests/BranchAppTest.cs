using NUnit.Framework;
using NUnit.Framework.Legacy;

namespace BranchApp.Tests
{
    [TestFixture]
    public class BranchAppTest
    {
        [Test]
        public void FirstAppTest()
        {
            Console.WriteLine("Oksana's first test!!!");
            ClassicAssert.IsTrue(true);
        }
    }
}
