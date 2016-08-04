import unittest
import sys
import os
sys.path.insert(0, os.path.abspath('..'))
from mapper.projectMapper import ProjectMapper
from domain.project import Project

class ProjectMapperTest(unittest.TestCase):
    def setUp(self):
        self.prMapper = ProjectMapper()

    def testFind(self):
        rs = self.prMapper.find(1)
        self.assertIsInstance(rs,  Project)
        self.assertEqual(rs.project_id, 1)

if __name__ == "__main__":
    unittest.main()
